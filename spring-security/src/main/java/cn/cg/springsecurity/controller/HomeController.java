package cn.cg.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: cg
 * @date: 2023-08-03 13:39
 **/
@Controller
public class HomeController {

    @PostMapping("/home")
    public String toHome() {
        //获取认证上下文
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println(principal.toString());

        return "redirect:/home.html";
    }

    @PostMapping("/fail")
    public String fail() {
        return "redirect:/fail.html";
    }
}
