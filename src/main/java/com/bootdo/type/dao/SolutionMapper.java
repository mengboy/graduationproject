package com.bootdo.type.dao;

import com.bootdo.type.domain.Solution;

import java.util.List;
import java.util.Map;

public interface SolutionMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Solution record);

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKeyWithBLOBs(Solution record);

    int updateByPrimaryKey(Solution record);

    List<Solution> list(Map<String, Object> map);

    int count();
}