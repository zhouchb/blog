package com.zhouchb.blog.dao;

import com.zhouchb.blog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :11:04
 * @Description
 */
@Mapper
public interface UserRepository {
    public User getNameAndPasswordDao(@Param("username") String username, @Param("password") String password);

}
