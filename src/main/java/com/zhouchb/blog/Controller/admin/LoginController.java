package com.zhouchb.blog.Controller.admin;

import com.zhouchb.blog.bean.User;
import com.zhouchb.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :13:28
 * @Description
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;
    //登录页面
    @GetMapping
    public String toLogin(){
        return "admin/login";
    }
    //登录判断
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes,
                        HttpSession session){
        User user = userService.getNameAndPassword(username, password);
        if (user != null){
           user.setPassword(null);
           session.setAttribute("username",username);
           return "admin/index";
        }else {
            redirectAttributes.addFlashAttribute("errorMessage","用户名或密码错误");
            return "redirect:/admin";
        }

    }
    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "admin/login";
    }

    @GetMapping("/release")
    public String toRelease(){
        return "admin/release";
    }
    @GetMapping("/index")
    public String toAdminIndex(){
        return "admin/index";
    }
}
