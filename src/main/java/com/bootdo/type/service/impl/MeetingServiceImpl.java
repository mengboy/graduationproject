package com.bootdo.type.service.impl;

import com.bootdo.common.utils.Query;
import com.bootdo.type.dao.MeetingMapper;
import com.bootdo.type.domain.Meeting;
import com.bootdo.type.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    MeetingMapper meetingMapper;

    @Override
    public void insert(Meeting meeting) {
        meetingMapper.insertSelective(meeting);
    }

    @Override
    public void update(Meeting meeting) {
        meetingMapper.updateByPrimaryKeySelective(meeting);
    }

    @Override
    public void upDelStatus(Integer id) {
        meetingMapper.upDelStatus(id);
    }

    @Override
    public Meeting select(Integer id) {
        return meetingMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Meeting> list(Query query) {
        return meetingMapper.list(query);
    }

    @Override
    public int count() {
        return meetingMapper.count();
    }
}
