package com.bootdo.type.dao;

import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.Meeting;

import java.util.List;
import java.util.Map;

public interface MeetingMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);

    void upDelStatus(Integer mId);

    List<Meeting> list(Map map);

    int count();
}