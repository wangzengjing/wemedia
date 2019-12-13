package com.anpu.wemedia.config.service;


import com.anpu.wemedia.domain.TbPermission;
import com.anpu.wemedia.domain.TbRole;
import com.anpu.wemedia.domain.TbUser;
import com.anpu.wemedia.service.TbPermissionService;
import com.anpu.wemedia.service.TbRoleService;
import com.anpu.wemedia.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Autowired
    private TbRoleService tbRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        TbUser tbUser = tbUserService.getByUsername(username);

        ArrayList<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

        if(tbUser != null){
//            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
//            tbPermissions.forEach(tbPermission -> {
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
//                grantedAuthorities.add(grantedAuthority);
//            });
            List<TbRole> tbRoles = tbRoleService.selectByUserId(tbUser.getId());
            tbRoles.forEach(tbRole->{
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbRole.getEnname());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(tbUser.getUsername(),tbUser.getPassword(),grantedAuthorities);
    }


}
