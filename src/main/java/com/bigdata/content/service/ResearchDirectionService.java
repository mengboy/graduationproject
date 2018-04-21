package com.bigdata.content.service;

import com.bigdata.content.domain.ResearchDirection;

import java.util.List;
import java.util.Map;

public interface ResearchDirectionService {
    List<ResearchDirection> list(Map<String, Object> params);

    int add(ResearchDirection researchDirection);

    int del(Integer id);

    int update(ResearchDirection researchDirection);

    ResearchDirection selectById(Integer id);

    List<ResearchDirection> getDirections();

    int count();

    List<ResearchDirection> getAllDirection();
}
