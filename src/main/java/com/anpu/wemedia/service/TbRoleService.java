package com.anpu.wemedia.service;

import com.anpu.wemedia.domain.TbRole;

import java.util.List;

public interface TbRoleService {

    List<TbRole> selectByUserId(Long userId);
}
