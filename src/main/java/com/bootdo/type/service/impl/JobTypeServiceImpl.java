package com.bootdo.type.service.impl;


import com.bootdo.type.dao.JobTypeMapper;
import com.bootdo.type.domain.JobType;
import com.bootdo.type.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("jobService")
public class JobTypeServiceImpl implements JobTypeService{

    @Autowired
    JobTypeMapper jobTypeMapper;

    @Override
    public List<JobType> listJobType(Map<String, Object> map) {
        return jobTypeMapper.list(map);
    }

    @Override
    public int insertJobType(JobType jobType) {
        return jobTypeMapper.insertSelective(jobType);
    }

    @Override
    public int delJobType(Integer id) {
        return jobTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateJobType(JobType jobType) {
        return jobTypeMapper.updateByPrimaryKeySelective(jobType);
    }

    @Override
    public int count() {
        return jobTypeMapper.count();
    }

    @Override
    public Object selectType(Integer id) {
        return jobTypeMapper.selectByPrimaryKey(id);
    }
}
