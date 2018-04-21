package com.bigdata.content.dao;

import com.bigdata.content.domain.Team;

import java.util.List;
import java.util.Map;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKeyWithBLOBs(Team record);

    int updateByPrimaryKey(Team record);

    List<Team> teams(Map<String, Object> map);

    int count();
}