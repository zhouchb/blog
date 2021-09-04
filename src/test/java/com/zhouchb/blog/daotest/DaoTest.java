package com.zhouchb.blog.daotest;

import com.zhouchb.blog.bean.User;
import com.zhouchb.blog.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :14:46
 * @Description
 */
@SpringBootTest
public class DaoTest {
    @Autowired
    UserRepository userRepository;
    @Test
    public void test1(){
        User nameAndPasswordDao = userRepository.getNameAndPasswordDao("123", "123");
        System.out.println(nameAndPasswordDao);
    }

}
