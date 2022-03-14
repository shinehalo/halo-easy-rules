package com.halo.rule.config;

import com.halo.rule.service.BizRuleService;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.support.composite.CompositeRule;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author halo
 * @description
 * @date 2022/03/14
 */
@Component
public class BizRulesConfig {

    @Resource
    private BizRuleService bizRuleService;

    /**
     * 构建rules配置
     * @param ruleName
     * @return
     */
    public Rules fetchConfigRules(String ruleName) {
        CompositeRule compositeRule = bizRuleService.ruleDefinitions(ruleName);

        Rules rules = new Rules();
        rules.register(compositeRule);
        return rules;
    }
}
