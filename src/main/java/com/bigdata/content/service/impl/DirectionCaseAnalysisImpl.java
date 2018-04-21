package com.bigdata.content.service.impl;

import com.bigdata.content.dao.CaseAnalysisMapper;
import com.bigdata.content.domain.CaseAnalysis;
import com.bigdata.content.service.DirectionCaseAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("caseAnalysis")
public class DirectionCaseAnalysisImpl implements DirectionCaseAnalysisService {

    @Autowired
    CaseAnalysisMapper caseAnalysisMapper;

    @Override
    public List<CaseAnalysis> getCaseAnalysisList(Map<String, Object> map) {
        return caseAnalysisMapper.list(map);
    }

    @Override
    public int insertCaseAnalysis(CaseAnalysis analysis) {
        return caseAnalysisMapper.insertSelective(analysis);
    }

    @Override
    public CaseAnalysis getCaseAnalysis(Integer id) {
        return caseAnalysisMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delCaseAnalysis(Integer id) {
        return caseAnalysisMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int count() {
        return caseAnalysisMapper.count();
    }

    @Override
    public void upCaseAnalysis(CaseAnalysis caseAnalysis) {
        caseAnalysisMapper.updateByPrimaryKeySelective(caseAnalysis);
    }

    @Override
    public List<CaseAnalysis> getCaseAnalysisByRdID(Integer rdid) {
        return caseAnalysisMapper.getCaseAnalysisByRdID(rdid);
    }
}
