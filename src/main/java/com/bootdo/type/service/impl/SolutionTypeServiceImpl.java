package com.bootdo.type.service.impl;

import com.bootdo.type.dao.SolutionTypeMapper;
import com.bootdo.type.domain.SolutionType;
import com.bootdo.type.service.SolutionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("soluctionType")
public class SolutionTypeServiceImpl implements SolutionTypeService{

    @Autowired
    SolutionTypeMapper solutionTypeMapper;

    @Override
    public List<SolutionType> list(Map<String, Object> map) {
        return solutionTypeMapper.list(map);
    }

    @Override
    public int insert(SolutionType solutionType) {
        return solutionTypeMapper.insertSelective(solutionType);
    }

    @Override
    public int del(Integer id) {
        return solutionTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int count() {
        return solutionTypeMapper.count();
    }

    @Override
    public List<SolutionType> list() {
        return solutionTypeMapper.solutionTypes();
    }

    @Override
    public SolutionType select(Integer stid) {
        return solutionTypeMapper.selectByPrimaryKey(stid);
    }
}
