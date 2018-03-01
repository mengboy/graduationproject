package com.bootdo.type.service.impl;

import com.bootdo.type.dao.DiscussSpaceMapper;
import com.bootdo.type.domain.DiscussSpace;
import com.bootdo.type.service.DirectionDiscussSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("discussSpace")
public class DisrectionDiscussSpaceServiceImpl implements DirectionDiscussSpaceService{
    @Autowired
    DiscussSpaceMapper discussSpaceMapper;


    @Override
    public int insert(DiscussSpace discussSpace) {
        return discussSpaceMapper.insertSelective(discussSpace);
    }

    @Override
    public List<DiscussSpace> list(Map<String, Object> map) {
        return discussSpaceMapper.list(map);
    }

    @Override
    public DiscussSpace select(Integer id) {
        return discussSpaceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int del(Integer id) {
        return discussSpaceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int count() {
        return discussSpaceMapper.count();
    }

    @Override
    public void upCaseAnalysis(DiscussSpace discussSpace) {
        discussSpaceMapper.updateByPrimaryKeySelective(discussSpace);
    }

    @Override
    public List<DiscussSpace> getDiscussSpace(Integer rdid) {
        return discussSpaceMapper.getDiscussSpace(rdid);
    }
}
