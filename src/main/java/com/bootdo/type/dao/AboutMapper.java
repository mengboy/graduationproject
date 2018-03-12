package com.bootdo.type.dao;

import com.bootdo.type.domain.About;

public interface AboutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(About record);

    int insertSelective(About record);

    About selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(About record);

    int updateByPrimaryKeyWithBLOBs(About record);

    int updateByPrimaryKey(About record);

    About select();
}