package com.halo.rule.listener;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author halo
 * @description
 * @date 2022/03/14
 */
public class DefaultRulesListener implements RuleListener {
    private static final Logger logger = LoggerFactory.getLogger(DefaultRulesListener.class);

    @Override
    public boolean beforeEvaluate(Rule rule, Facts facts) {
        return true;
    }

    @Override
    public void afterEvaluate(Rule rule, Facts facts, boolean b) {
        logger.info("ruleName:{} 执行条件结果为:{}", rule.getName(), b);
    }

    @Override
    public void beforeExecute(Rule rule, Facts facts) {

    }

    @Override
    public void onSuccess(Rule rule, Facts facts) {
        logger.info("rule execute success...ruleName:{}", rule.getName());
    }

    @Override
    public void onFailure(Rule rule, Facts facts, Exception e) {
        logger.info("rule execute fail...ruleName:{}", rule.getName());
    }
}
