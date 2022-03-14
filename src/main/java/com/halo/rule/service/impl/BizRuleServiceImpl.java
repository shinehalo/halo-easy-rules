package com.halo.rule.service.impl;

import com.halo.rule.enums.CompositeRuleTypeEnum;
import com.halo.rule.helper.BizRuleHelper;
import com.halo.rule.mapper.BizRuleMapper;
import com.halo.rule.pojo.domain.BizRuleComposePo;
import com.halo.rule.pojo.domain.BizRulePo;
import com.halo.rule.service.BizRuleComposeService;
import com.halo.rule.service.BizRuleService;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.support.RuleDefinition;
import org.jeasy.rules.support.composite.ActivationRuleGroup;
import org.jeasy.rules.support.composite.CompositeRule;
import org.jeasy.rules.support.composite.ConditionalRuleGroup;
import org.jeasy.rules.support.composite.UnitRuleGroup;
import org.mvel2.ParserContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author halo
 * @description
 * @date 2022/03/14
 */
@Service
public class BizRuleServiceImpl implements BizRuleService {

    @Resource
    private BizRuleMapper bizRuleMapper;

    @Resource
    private BizRuleComposeService ruleComposeService;

    @Override
    public int insert(BizRulePo po) {
        return bizRuleMapper.insert(po);
    }

    @Override
    public List<BizRulePo> selectByName(String name) {
        return bizRuleMapper.selectByName(name);
    }

    @Override
    public CompositeRule ruleDefinitions(String groupCode) {
        //查询规则
        List<BizRulePo> bizRulePoList = this.selectByName(groupCode);
        if (CollectionUtils.isEmpty(bizRulePoList)) {
            throw new RuntimeException("规则定义不存在");
        }

        CompositeRule compositeRule;
        BizRulePo bizRule = bizRulePoList.get(0);

        switch (CompositeRuleTypeEnum.of(bizRule.getCompositeType())) {
            case AND:
                compositeRule = new UnitRuleGroup();
                break;
            case ALL:
                compositeRule = new ConditionalRuleGroup();
                break;
            default:
                compositeRule = new ActivationRuleGroup();
        }

        compositeRule.setDescription(bizRule.getDescription());
        compositeRule.setPriority(bizRule.getPriority());
        //规则组合数据
        List<BizRuleComposePo> bizRuleComposePoList = ruleComposeService.selectByRule(bizRule.getId());
        CompositeRule finalComposeRule = compositeRule;

        BizRuleHelper bizRuleHelper = new BizRuleHelper(new ParserContext());
        //规则定义
        bizRuleComposePoList.forEach(bizRuleCompose -> {
            RuleDefinition definition = new RuleDefinition();
            definition.setName(bizRuleCompose.getName());

            BeanUtils.copyProperties(bizRuleCompose, definition);
            if (!StringUtils.isEmpty(bizRuleCompose.getActions())) {
                List<String> actions = Arrays.asList(bizRuleCompose.getActions().split(";"));
                definition.setActions(actions);
            }

            Rule rule = bizRuleHelper.createSimpleRule(definition);
            finalComposeRule.addRule(rule);
        });

        return finalComposeRule;
    }
}
