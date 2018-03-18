package com.bootdo.type.dao;

import com.bootdo.type.domain.Position;

import java.util.List;
import java.util.Map;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKeyWithBLOBs(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> list(Map<String, Object> map);

    int count();

    List<Position> getPositionByPlace(String workPlace);

    List<String> getWorkPlaces();
}