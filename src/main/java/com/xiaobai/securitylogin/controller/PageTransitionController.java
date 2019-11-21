package com.xiaobai.securitylogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 *
 * @author 小白
 * @date 2019/11/20
 */
@Controller
public class PageTransitionController {
    @RequestMapping("")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/registerPage")
    public String register () {
        return "register.html";
    }
}
