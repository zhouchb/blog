package com.zhouchb.blog.daotest;

import com.zhouchb.blog.bean.Tag;
import com.zhouchb.blog.bean.Type;
import com.zhouchb.blog.bean.User;
import com.zhouchb.blog.dao.TypeRepository;
import com.zhouchb.blog.dao.UserRepository;
import com.zhouchb.blog.service.impl.TagServicImpl;
import com.zhouchb.blog.service.impl.TypeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :14:46
 * @Description
 */
@SpringBootTest
public class DaoTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    TagServicImpl tagServic;

    @Test
    public void test1(){
        User nameAndPasswordDao = userRepository.getNameAndPasswordDao("123", "123");
        System.out.println(nameAndPasswordDao);
    }

    @Test
    public void testTx(){
        int test1 = typeService.saveType(new Type(null, "test8"));
        System.out.println(test1);
    }

    @Test
    public void test03(){
        for (Tag tag : tagServic.listTagService()) {
            System.out.println(tag);
        }

    }



}
