package com.zhouchb.blog.Controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhouchb.blog.bean.Blog;
import com.zhouchb.blog.bean.Tag;
import com.zhouchb.blog.bean.Type;
import com.zhouchb.blog.service.BlogService;
import com.zhouchb.blog.service.TagesService;
import com.zhouchb.blog.service.TypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :16:23
 * @Description
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypesService typesService;
    @Autowired
    private TagesService tagesService;

    @GetMapping("/blogs")
    public String blogs(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Blog blog, Model model) {
        PageHelper.startPage(pn, 6);
        List<Type> types = typesService.listType();
        List<Blog> blogs = blogService.listBlogService(blog);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogs, 5);
        model.addAttribute("blogpageInfo", blogPageInfo);
        model.addAttribute("types",types);
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String blogsSearch(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Blog blog, Model model) {
        PageHelper.startPage(pn, 6);
        List<Blog> blogs = blogService.listBlogService(blog);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogs, 5);
        model.addAttribute("blogpageInfo", blogPageInfo);
        return "admin/blogs :: blogList"; //blogs页面下的bloglist
    }

    @GetMapping("/release")
    public String toRelease(Model model){
        List<Type> types = typesService.listType();
        List<Tag> tags = tagesService.listTagService();
        model.addAttribute("blog",new Blog());
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        return "admin/release";
    }

    //新增博客
    @PostMapping("/blogs")
    public String saveBlog(Blog blog, HttpSession session, RedirectAttributes redirectAttributes){

        return "admin/blogs";
    }
}
