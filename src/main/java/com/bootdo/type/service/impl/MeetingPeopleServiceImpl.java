package com.bootdo.type.service.impl;


import com.bootdo.common.utils.Query;
import com.bootdo.type.dao.MeetingPeopleMapper;
import com.bootdo.type.domain.MeetingPeople;
import com.bootdo.type.service.MeetingPeopleService;
import com.bootdo.type.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("meetingPeopleService")
public class MeetingPeopleServiceImpl implements MeetingPeopleService{

    @Autowired
    MeetingPeopleMapper meetingPeopleMapper;

    @Override
    public void insert(MeetingPeople meetingPeople) {
        meetingPeopleMapper.insertSelective(meetingPeople);
    }

    @Override
    public void update(MeetingPeople meetingPeople) {
        meetingPeopleMapper.updateByPrimaryKeySelective(meetingPeople);
    }

    @Override
    public void upDelStatus(Integer mpId) {

        meetingPeopleMapper.upDelStatus(mpId);
    }

    @Override
    public MeetingPeople select(Integer id) {
        return meetingPeopleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MeetingPeople> list(Query query) {
        return meetingPeopleMapper.list(query);
    }

    @Override
    public int count() {
        return meetingPeopleMapper.count();
    }
}
