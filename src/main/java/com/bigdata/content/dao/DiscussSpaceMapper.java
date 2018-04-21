package com.bigdata.content.dao;

import com.bigdata.content.domain.DiscussSpace;

import java.util.List;
import java.util.Map;

public interface DiscussSpaceMapper {
    int deleteByPrimaryKey(Integer dsid);

    int insert(DiscussSpace record);

    int insertSelective(DiscussSpace record);

    DiscussSpace selectByPrimaryKey(Integer dsid);

    int updateByPrimaryKeySelective(DiscussSpace record);

    int updateByPrimaryKey(DiscussSpace record);

    List<DiscussSpace> list(Map<String, Object> map);

    int count();

    List<DiscussSpace> getDiscussSpace(Integer rdid);
}