package com.zhouchb.blog;

import com.zhouchb.blog.bean.User;
import com.zhouchb.blog.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Test
    public void test1(){
        User nameAndPasswordDao = userRepository.getNameAndPasswordDao("123", "123");
        System.out.println(nameAndPasswordDao);
    }

    @Test
    void contextLoads() {
    }

}
