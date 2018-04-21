package com.bigdata.content.dao;

import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.MeetingPeople;

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