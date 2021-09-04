package com.zhouchb.blog.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/2 :10:38
 * @Description
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String toIndex(){
 /*       int i= 5/0;
        String blog = null;
        if (blog==null){
            throw new NotFoundException("页面不见了");
        }*/
        return "index";
    }
    @GetMapping("/blogs")
    public String toBlog(){
        return "admin/release";
    }
    @GetMapping("/types")
    public String toAbout(){
        return "types";
    }
}
