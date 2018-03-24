package com.bootdo.type.service;

import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.Meeting;
import com.bootdo.type.domain.Signature;

import java.util.List;
import java.util.Map;

public interface MeetingService {
    void insert(Meeting meeting);

    void update(Meeting meeting);

    void upDelStatus(Integer id);

    Meeting select(Integer id);

    List<Meeting> list(Map map);

    int count();
}
