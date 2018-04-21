package com.bigdata.type.service.impl;


import com.bigdata.content.dao.JobTypeMapper;
import com.bigdata.content.domain.JobType;
import com.bigdata.content.service.JobTypeService;
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
