package com.bigdata.content.dao;

import com.bigdata.content.domain.JobType;

import java.util.List;
import java.util.Map;

public interface JobTypeMapper {
    int deleteByPrimaryKey(Integer jtId);

    int insert(JobType record);

    int insertSelective(JobType record);

    JobType selectByPrimaryKey(Integer jtId);

    int updateByPrimaryKeySelective(JobType record);

    int updateByPrimaryKeyWithBLOBs(JobType record);

    int updateByPrimaryKey(JobType record);

    List<JobType> list(Map<String, Object> map);

    int count();
}