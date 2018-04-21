package com.bigdata.content.service.impl;


import com.bigdata.content.dao.TeamRepresentativeMapper;
import com.bigdata.content.domain.TeamRepresentative;
import com.bigdata.content.service.TeamRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("teamRepresentativeService")
public class TeamRepresentativeServiceImpl implements TeamRepresentativeService{

    @Autowired
    TeamRepresentativeMapper teamRepresentativeMapper;

    @Override
    public List<TeamRepresentative> teamRepresentatives(Map<String, Object> map) {
        return teamRepresentativeMapper.list(map);
    }

    @Override
    public int count() {
        return teamRepresentativeMapper.count();
    }

    @Override
    public int add(TeamRepresentative teamRepresentative) {
        return teamRepresentativeMapper.insert(teamRepresentative);
    }

    @Override
    public int del(Integer id) {
        return teamRepresentativeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TeamRepresentative get(Integer id) {
        return teamRepresentativeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(TeamRepresentative teamRepresentative) {
        return teamRepresentativeMapper.updateByPrimaryKeySelective(teamRepresentative);
    }
}
