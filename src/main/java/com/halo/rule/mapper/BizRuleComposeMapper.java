package com.halo.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.halo.rule.pojo.domain.BizRuleComposePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author halo
 * @description
 * @date 2022/03/14
 */
public interface BizRuleComposeMapper extends BaseMapper<BizRuleComposePo> {

    /**
     * 通过规则查
     *
     * @param ruleId 规则ID
     * @return 结果
     */
    List<BizRuleComposePo> selectByRule(@Param("ruleId") Long ruleId);

    /**
     * 批量插入
     *
     * @param list 参数
     * @return 结果
     */
    int batchInsert(List<BizRuleComposePo> list);

    /**
     * 更新
     *
     * @param bo 参数
     * @return 结果
     */
    int update(BizRuleComposePo bo);
}
