package com.halo.rule.service.impl;

import com.halo.rule.mapper.BizRuleComposeMapper;
import com.halo.rule.pojo.domain.BizRuleComposePo;
import com.halo.rule.service.BizRuleComposeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author halo
 * @description 规则组合
 * @date 2022/03/14
 */
@Service
public class BizRuleComposeServiceImpl implements BizRuleComposeService {

    @Resource
    private BizRuleComposeMapper bizRuleComposeMapper;

    @Override
    public int batchInsert(List<BizRuleComposePo> list) {
        return bizRuleComposeMapper.batchInsert(list);
    }

    @Override
    public List<BizRuleComposePo> selectByRule(Long ruleId) {
        return bizRuleComposeMapper.selectByRule(ruleId);
    }

    @Override
    public int update(BizRuleComposePo po) {
        return bizRuleComposeMapper.update(po);
    }
}
