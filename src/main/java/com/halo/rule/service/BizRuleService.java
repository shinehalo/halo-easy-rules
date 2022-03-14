package com.halo.rule.service;

import com.halo.rule.pojo.domain.BizRulePo;
import org.jeasy.rules.support.composite.CompositeRule;

import java.util.List;

/**
 * @author halo
 * @description 规则
 * @date 2022/03/14
 */
public interface BizRuleService {

    /**
     * 新增数据
     * @param po
     * @return
     */
    int insert(BizRulePo po);

    /**
     * 通过名称查询
     * @param name
     * @return
     */
    List<BizRulePo> selectByName(String name);

    /**
     * 找出该组所有的规则
     * @param groupCode
     * @return
     */
    CompositeRule ruleDefinitions(String groupCode);
}
