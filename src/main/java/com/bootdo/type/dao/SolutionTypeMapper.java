package com.bootdo.type.dao;

import com.bootdo.type.domain.Solution;
import com.bootdo.type.domain.SolutionType;

import java.util.List;
import java.util.Map;

public interface SolutionTypeMapper {
    int deleteByPrimaryKey(Integer stid);

    int insert(SolutionType record);

    int insertSelective(SolutionType record);

    SolutionType selectByPrimaryKey(Integer stid);

    int updateByPrimaryKeySelective(SolutionType record);

    int updateByPrimaryKey(SolutionType record);

    List<SolutionType> list(Map<String, Object> map);

    List<SolutionType> solutionTypes();

    int count();
}