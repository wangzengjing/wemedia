package com.anpu.wemedia.service;

import com.anpu.wemedia.domain.TbUser;

public interface TbUserService {

    TbUser getByUsername(String username);

    void save(TbUser tbUser);

    void presave(TbUser tbUser);
}



