package com.halo.rule.helper;

import org.jeasy.rules.api.Rule;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.support.AbstractRuleFactory;
import org.jeasy.rules.support.RuleDefinition;
import org.mvel2.ParserContext;

/**
 * @author halo
 * @description
 * @date 2022/03/14
 */
public class BizRuleHelper extends AbstractRuleFactory {

    private final ParserContext parserContext;

    public BizRuleHelper(ParserContext parserContext) {
        this.parserContext = parserContext;
    }

    @Override
    public Rule createSimpleRule(RuleDefinition ruleDefinition) {
        MVELRule mvelRule = new MVELRule(parserContext)
                .name(ruleDefinition.getName())
                .description(ruleDefinition.getDescription())
                .priority(ruleDefinition.getPriority())
                .when(ruleDefinition.getCondition());

        for (String action : ruleDefinition.getActions()) {
            mvelRule.then(action);
        }

        return mvelRule;
    }
}
