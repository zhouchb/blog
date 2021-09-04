package com.zhouchb.blog.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/3 :14:37
 * @Description
 */
public class Tag {
    private Long id;
    private String name;
    //博客
    private List<Blog> blogs = new ArrayList<>();
    public Tag() {
    }

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

