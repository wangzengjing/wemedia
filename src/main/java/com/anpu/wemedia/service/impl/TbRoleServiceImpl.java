package com.anpu.wemedia.service.impl;

import com.anpu.wemedia.domain.TbRole;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.anpu.wemedia.mapper.TbRoleMapper;
import com.anpu.wemedia.service.TbRoleService;

import java.util.List;

@Service
public class TbRoleServiceImpl implements TbRoleService{

    @Resource
    private TbRoleMapper tbRoleMapper;

    @Override
    public List<TbRole> selectByUserId(Long userId) {
        return tbRoleMapper.selectByUserId(userId);

    }
}
