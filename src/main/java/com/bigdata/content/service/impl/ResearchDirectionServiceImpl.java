package com.bigdata.content.service.impl;


import com.bigdata.content.dao.ResearchDirectionMapper;
import com.bigdata.content.domain.ResearchDirection;
import com.bigdata.content.service.ResearchDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ResearchDirection")
public class ResearchDirectionServiceImpl implements ResearchDirectionService{

    @Autowired
    ResearchDirectionMapper researchDirectionMapper;


    @Override
    public List<ResearchDirection> list(Map<String, Object> params) {
        return researchDirectionMapper.list(params);
    }

    @Override
    public int add(ResearchDirection researchDirection) {
        return researchDirectionMapper.insertSelective(researchDirection);
    }

    @Override
    public int del(Integer id) {
        return researchDirectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(ResearchDirection researchDirection) {
        return researchDirectionMapper.updateByPrimaryKeySelective(researchDirection);
    }

    @Override
    public ResearchDirection selectById(Integer id) {
        return researchDirectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ResearchDirection> getDirections() {
        return researchDirectionMapper.getDirections();
    }

    @Override
    public int count() {
        return researchDirectionMapper.count();
    }

    @Override
    public List<ResearchDirection> getAllDirection() {
        return researchDirectionMapper.getDirections();
    }
}
