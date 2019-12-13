package com.anpu.wemedia.service.impl;

import com.anpu.wemedia.domain.TbUser;
import com.anpu.wemedia.mapper.TbRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.anpu.wemedia.mapper.TbUserMapper;
import com.anpu.wemedia.service.TbUserService;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Resource
    private TbRoleMapper tbRoleMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public TbUser getByUsername(String username) {
        Example example = new Example(TbUser.class);

        example.createCriteria().andEqualTo("username", username);
        return tbUserMapper.selectOneByExample(example);
    }


    @Override
    public void save(TbUser tbUser){
        this.presave(tbUser);

        tbUserMapper.insert(tbUser);
    }


    @Override
    public void presave(TbUser tbUser) {

        tbUser.setPassword(bCryptPasswordEncoder.encode(tbUser.getPassword()));
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

    }

}



