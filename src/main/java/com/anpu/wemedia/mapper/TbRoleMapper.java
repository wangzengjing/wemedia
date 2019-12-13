package com.anpu.wemedia.mapper;

import com.anpu.wemedia.domain.TbRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbRoleMapper extends MyMapper<TbRole> {

    List<TbRole> selectByUserId(@Param("userId") Long userId);
}