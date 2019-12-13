package com.anpu.wemedia.service;

import com.anpu.wemedia.domain.TbPermission;


import java.util.List;

public interface TbPermissionService {

    List<TbPermission> selectByUserId(Long userId);
}
