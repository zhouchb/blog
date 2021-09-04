package com.zhouchb.blog.service.impl;

import com.zhouchb.blog.bean.User;
import com.zhouchb.blog.dao.UserRepository;
import com.zhouchb.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :11:05
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getNameAndPassword(String username, String password) {
        User nameAndPasswordDao = userRepository.getNameAndPasswordDao(username, password);
        return nameAndPasswordDao;
    }
}
