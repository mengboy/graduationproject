package com.bootdo.type.service;

import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.MeetingPeople;
import com.bootdo.type.domain.Signature;

import java.util.List;

public interface MeetingPeopleService {
    void insert(MeetingPeople meetingPeople);

    void update(MeetingPeople meetingPeople);

    void upDelStatus(Integer id);

    MeetingPeople select(Integer id);

    List<MeetingPeople> list(Query query);

    int count();
}
