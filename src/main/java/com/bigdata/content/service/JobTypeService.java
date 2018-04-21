package com.bigdata.content.service;

import com.bigdata.content.domain.JobType;

import java.util.List;
import java.util.Map;

public interface JobTypeService {
    List<JobType> listJobType(Map<String, Object> map);

    int insertJobType(JobType jobType);

    int delJobType(Integer id);

    int updateJobType(JobType jobType);

    int count();

    Object selectType(Integer id);
}
