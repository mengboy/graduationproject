package com.bootdo.type.service.impl;

import com.bootdo.type.dao.ShowProjectMapper;
import com.bootdo.type.domain.ShowProject;
import com.bootdo.type.service.DirectionShowProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("showProject")
public class DirectionShowProjectImpl implements DirectionShowProject{

    @Autowired
    ShowProjectMapper showProjectMapper;

    @Override
    public int insertShowProject(ShowProject showProject) {
        return showProjectMapper.insertSelective(showProject);
    }

    @Override
    public int delShowProject(Integer id) {
        return showProjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ShowProject> selectShowProjects(Map<String, Object> map) {
        return showProjectMapper.selectShowProjects(map);
    }

    @Override
    public ShowProject selectShowProject(Integer id) {
        return showProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int upShowProject(ShowProject showProject) {
        return showProjectMapper.updateByPrimaryKeySelective(showProject);
    }

    @Override
    public int count() {
        return showProjectMapper.count();
    }

    @Override
    public List<ShowProject> getShowProjectByRdID(Integer rdid) {
        return showProjectMapper.getShowProjectByRdID(rdid);
    }
}
