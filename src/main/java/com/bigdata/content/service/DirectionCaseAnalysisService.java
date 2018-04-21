package com.bigdata.content.service;

import com.bigdata.content.domain.CaseAnalysis;

import java.util.List;
import java.util.Map;

public interface DirectionCaseAnalysisService {
    List<CaseAnalysis> getCaseAnalysisList(Map<String, Object> map);

    int insertCaseAnalysis(CaseAnalysis analysis);

    CaseAnalysis getCaseAnalysis(Integer id);

    int delCaseAnalysis(Integer id);
    
    int count();

    void upCaseAnalysis(CaseAnalysis caseAnalysis);

    List<CaseAnalysis> getCaseAnalysisByRdID(Integer rdid);
}
