package com.zhouchb.blog.service;

import com.zhouchb.blog.bean.Type;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;


import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :20:41
 * @Description
 */
public interface TypesService {
    //新增
    public int saveType(Type type);

    //查找
    public Type getType(Long id);

    public List<Type> listType();

    //更新
    public int updateType(Long id, Type type);

    //删除
    public void deleteType(Long id);

    //根据用户查询
    Type getTypeByName(String name);

}
