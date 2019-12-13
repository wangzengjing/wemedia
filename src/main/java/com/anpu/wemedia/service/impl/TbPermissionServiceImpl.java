package com.anpu.wemedia.service.impl;

import com.anpu.wemedia.domain.TbPermission;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.anpu.wemedia.mapper.TbPermissionMapper;
import com.anpu.wemedia.service.TbPermissionService;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService{

    @Resource
    private TbPermissionMapper tbPermissionMapper;


    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
