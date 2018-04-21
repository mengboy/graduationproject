package com.bigdata.content.service;

import com.bigdata.content.domain.Solution;

import java.util.List;
import java.util.Map;

public interface SolutionService {
    List<Solution> solutions(Map<String, Object> map);

    Solution getSolutionById(Integer id);

    int delSolution(Integer id);

    int insertSolution(Solution solution);

    int upSolution(Solution solution);

    int count();
}
