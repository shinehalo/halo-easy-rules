package com.halo.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.halo.rule.pojo.domain.BizRulePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description
 * @author halo
 * @date 2022/03/14
 */
public interface BizRuleMapper extends BaseMapper<BizRulePo> {

    /**
     * 通过名称查询所有的
     *
     * @param name 名称
     * @return 结果
     */
    List<BizRulePo> selectByName(@Param("name") String name);
}
