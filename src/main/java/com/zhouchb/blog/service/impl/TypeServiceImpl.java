package com.zhouchb.blog.service.impl;

import com.zhouchb.blog.bean.Type;
import com.zhouchb.blog.service.TypesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :21:42
 * @Description
 */
@Service
public class TypeServiceImpl implements TypesService {
    @Override
    public int saveType(Type type) {
        return 0;
    }

    @Override
    public Type getType(Long id) {
        return null;
    }

    @Override
    public List<Type> listType() {
        return null;
    }

    @Override
    public int updateType(Long id) {
        return 0;
    }

    @Override
    public void deleteType(Long id) {

    }
}
