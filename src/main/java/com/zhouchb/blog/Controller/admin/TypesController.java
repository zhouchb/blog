package com.zhouchb.blog.Controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouchb.blog.bean.Type;
import com.zhouchb.blog.service.TypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/5 :9:49
 * @Description
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class TypesController {

    @Autowired
    private TypesService typesService;

    @GetMapping
    public String types(@RequestParam(value = "pn",defaultValue =" 1")Integer pn, Model model){
        //传入页码，和一页显示多少
        PageHelper.startPage(pn,6);
        List<Type> types = typesService.listType();
        //连续显示多少页
        PageInfo<Type> typePageInfo = new PageInfo<>(types, 5);
        model.addAttribute("pageinfo",typePageInfo);
        return "admin/types";
    }
}
