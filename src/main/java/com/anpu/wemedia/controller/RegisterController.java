package com.anpu.wemedia.controller;

import com.anpu.wemedia.domain.TbUser;
import com.anpu.wemedia.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping("save")
    public String save(TbUser tbUser){
       // tbUserService.save(tbUser);
        userDetailsService.loadUserByUsername(tbUser.getUsername());
        return "index";
    }

}
