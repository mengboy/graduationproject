package com.bigdata.content.service;

import com.bigdata.content.domain.Meeting;

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
