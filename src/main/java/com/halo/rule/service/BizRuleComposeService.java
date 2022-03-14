package com.halo.rule.service;

import com.halo.rule.pojo.domain.BizRuleComposePo;
import com.halo.rule.pojo.domain.BizRulePo;
import org.jeasy.rules.support.composite.CompositeRule;

import java.util.List;

/**
 * @author halo
 * @description 规则组合
 * @date 2022/03/14
 */
public interface BizRuleComposeService {

    /**
     * 批量插入
     * @param list
     * @return
     */
    int batchInsert(List<BizRuleComposePo> list);

    /**
     * 通过规则查询
     * @param ruleId 规则ID
     * @return
     */
    List<BizRuleComposePo> selectByRule(Long ruleId);

    /**
     * 更新规则
     * @param po
     * @return
     */
    int update(BizRuleComposePo po);
}
