package com.bootdo.type.dao;

import com.bootdo.type.domain.CaseAnalysis;

import java.util.List;
import java.util.Map;

public interface CaseAnalysisMapper {
    int deleteByPrimaryKey(Integer caid);

    int insert(CaseAnalysis record);

    int insertSelective(CaseAnalysis record);

    CaseAnalysis selectByPrimaryKey(Integer caid);

    int updateByPrimaryKeySelective(CaseAnalysis record);

    int updateByPrimaryKey(CaseAnalysis record);

    List<CaseAnalysis> list(Map<String, Object> map);

    int count();

    List<CaseAnalysis> getCaseAnalysisByRdID(Integer rdid);
}