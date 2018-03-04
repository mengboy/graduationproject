package com.bootdo.type.dao;

import com.bootdo.type.domain.TeamRepresentative;

import java.util.List;
import java.util.Map;

public interface TeamRepresentativeMapper {
    int deleteByPrimaryKey(Integer trid);

    int insert(TeamRepresentative record);

    TeamRepresentative insertSelective(TeamRepresentative record);

    TeamRepresentative selectByPrimaryKey(Integer trid);

    int updateByPrimaryKeySelective(TeamRepresentative record);

    int updateByPrimaryKey(TeamRepresentative record);

    List<TeamRepresentative> list(Map<String, Object> map);

    int count();
}