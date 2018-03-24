package com.bootdo.type.dao;

import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.MeetingPeople;

import java.util.List;

public interface MeetingPeopleMapper {
    int deleteByPrimaryKey(Integer mpId);

    int insert(MeetingPeople record);

    int insertSelective(MeetingPeople record);

    MeetingPeople selectByPrimaryKey(Integer mpId);

    int updateByPrimaryKeySelective(MeetingPeople record);

    int updateByPrimaryKey(MeetingPeople record);

    void upDelStatus(Integer mpId);

    List<MeetingPeople> list(Query query);

    int count();
}