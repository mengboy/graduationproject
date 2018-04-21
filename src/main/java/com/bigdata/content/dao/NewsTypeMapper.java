package com.bigdata.content.dao;

import com.bigdata.content.domain.NewsType;

import java.util.List;
import java.util.Map;

public interface NewsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsType record);

    int insertSelective(NewsType record);

    NewsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsType record);

    int updateByPrimaryKey(NewsType record);

    List<NewsType> selectNewsTypes(Map<String, Object> params);

    int count();

    List<NewsType> getTypes();
}