package com.zhouchb.blog.service;

import com.zhouchb.blog.bean.User;
import com.zhouchb.blog.util.MD5Utils;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :11:05
 * @Description
 */
public interface UserService {
    public User getNameAndPassword(String username, String password);

}
