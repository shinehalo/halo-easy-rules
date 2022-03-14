package com.halo.rule.config;

import com.halo.rule.listener.DefaultRulesListener;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.api.RuleListener;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author halo
 * @description
 * @date 2022/03/14
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    @ConditionalOnMissingBean
    public RuleListener defaultRulesListener() {
        return new DefaultRulesListener();
    }

    @Bean
    @ConditionalOnMissingBean(RulesEngine.class)
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RulesEngine rulesEngine(RuleListener defaultRulesListener) {
        RulesEngineParameters parameters = new RulesEngineParameters();

        DefaultRulesEngine rulesEngine = new DefaultRulesEngine(parameters);
        rulesEngine.registerRuleListener(defaultRulesListener);
        return rulesEngine;
    }
}
