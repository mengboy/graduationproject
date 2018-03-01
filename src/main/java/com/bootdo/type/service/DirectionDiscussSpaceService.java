package com.bootdo.type.service;

import com.bootdo.type.domain.DiscussSpace;

import java.util.List;
import java.util.Map;

public interface DirectionDiscussSpaceService {
    int insert(DiscussSpace discussSpace);

    List<DiscussSpace> list(Map<String, Object> map);

    DiscussSpace select(Integer id);

    int del(Integer id);

    int count();

    void upCaseAnalysis(DiscussSpace discussSpace);
}
