package com.halo.rule.controller;

import com.halo.rule.pojo.domain.BizRulePo;
import com.halo.rule.service.BizRuleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author halo
 * @description
 * @date 2022/03/14
 */
@RestController
public class BizRuleController {

    @Resource
    private BizRuleService bizRuleService;

    @PostMapping(value = "/rule/add")
    @ResponseBody
    public String add(@RequestBody BizRulePo po) {
        bizRuleService.insert(po);
        return "OK";
    }
}
