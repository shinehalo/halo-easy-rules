package com.halo.rule.enums;


/**
 * @author halo
 * @description 规则组合类型
 * @date 2022/03/11
 */
public enum CompositeRuleTypeEnum {

    /**
     * 要么应用所有规则，要么不应用任何规则
     */
    AND(1, "UnitRuleGroup"),
    /**
     * 它会触发第一个适应规则，而忽略该组中的其他规则（XOR逻辑）
     */
    XOR(2, "ActivationRuleGroup"),
    /**
     * 条件规则组是一个组合规则，其中具有最高优先级的规则作为条件：如果具有最高优先级的规则求值为true，则将触发其余规则
     */
    ALL(3, "ConditionalRuleGroup");

    private Integer code;
    private String name;

    CompositeRuleTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static CompositeRuleTypeEnum of(Integer code) {
        if (code != null) {
            for (CompositeRuleTypeEnum item : CompositeRuleTypeEnum.values()) {
                if (item.code.intValue() == code) {
                    return item;
                }
            }
        }
        //默认值
        return CompositeRuleTypeEnum.XOR;
    }
}
