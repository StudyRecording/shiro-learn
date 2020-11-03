package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {


    @RequestMapping("/find")
//    @RequiresRoles(value = {"admin"})
    @RequiresPermissions("user:*:*")
    public String find() {

        System.out.println("-------进入find方法");
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.hasRole("admin")) {
//            System.out.println("admin权限");
//        } else {
//            System.out.println("user权限");
//        }

        return "redirect:/login.jsp";
    }
}
