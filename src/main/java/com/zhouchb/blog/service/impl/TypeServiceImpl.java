package com.zhouchb.blog.service.impl;

import com.zhouchb.blog.bean.Type;
import com.zhouchb.blog.dao.TypeRepository;
import com.zhouchb.blog.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :21:42
 * @Description
 */
@Service
public class TypeServiceImpl implements TypesService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public int saveType(Type type) {
        int i = typeRepository.saveTypeDao(type);
        return i;
    }

    @Override
    public Type getType(Long id) {
        Type type = typeRepository.getTypeDao(id);
        return type;
    }

    @Override
    public List<Type> listType() {
        List<Type> types = typeRepository.listType();
        return types;
    }

    @Override
    public int updateType(Long id, Type type) {
        int i = typeRepository.updateTypeDao(id, type);
        return i;
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteTypeDao(id);
    }
}
