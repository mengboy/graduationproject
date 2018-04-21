package com.bigdata.content.service;

import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.MeetingPeople;

import java.util.List;

public interface MeetingPeopleService {
    void insert(MeetingPeople meetingPeople);

    void update(MeetingPeople meetingPeople);

    void upDelStatus(Integer id);

    MeetingPeople select(Integer id);

    List<MeetingPeople> list(Query query);

    int count();
}
