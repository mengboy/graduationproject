package com.bigdata.content.service.impl;


import com.bigdata.common.utils.Query;
import com.bigdata.content.dao.MeetingPeopleMapper;
import com.bigdata.content.domain.MeetingPeople;
import com.bigdata.content.service.MeetingPeopleService;
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
