package com.zhouchb.blog.dao;

import com.zhouchb.blog.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :22:14
 * @Description
 */
@Mapper
public interface TypeRepository {
    //新增
    public int saveTypeDao(Type type);
    //查找
    public Type getTypeDao(Long id);
    public List<Type> listType();
    //更新
    public int updateTypeDao(@Param("id") Long id,@Param("type")Type type);
    //删除
    public void deleteTypeDao(Long id);

}
