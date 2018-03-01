package com.bootdo.type.dao;

import com.bootdo.type.domain.ResearchDirection;

import java.util.List;
import java.util.Map;

public interface ResearchDirectionMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(ResearchDirection record);

    int insertSelective(ResearchDirection record);

    ResearchDirection selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(ResearchDirection record);

    int updateByPrimaryKeyWithBLOBs(ResearchDirection record);

    int updateByPrimaryKey(ResearchDirection record);

    List<ResearchDirection> list(Map<String, Object> params);

    int count();

    List<ResearchDirection> getDirections();
}