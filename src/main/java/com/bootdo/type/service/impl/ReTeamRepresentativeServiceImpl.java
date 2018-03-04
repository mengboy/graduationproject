package com.bootdo.type.service.impl;

import com.bootdo.type.dao.ReTeamRepresentativeMapper;
import com.bootdo.type.domain.ReTeamRepresentative;
import com.bootdo.type.service.ReTeamRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("reTeamRepresentativeService")
public class ReTeamRepresentativeServiceImpl implements ReTeamRepresentativeService{

    @Autowired
    ReTeamRepresentativeMapper reTeamRepresentativeMapper;

    @Override
    public List<ReTeamRepresentative> reTeamRepresentative(Integer trid) {
        return reTeamRepresentativeMapper.selectBytrid(trid);
    }

    @Override
    public int insert(ReTeamRepresentative reTeamRepresentative) {
        return reTeamRepresentativeMapper.insertSelective(reTeamRepresentative);
    }

    @Override
    public int del(Integer id) {
        return reTeamRepresentativeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ReTeamRepresentative> rtrId(Integer trId) {
        return reTeamRepresentativeMapper.selectByidAdntid(trId);
    }

    @Override
    public void up(ReTeamRepresentative reTeamRepresentative) {
        reTeamRepresentativeMapper.updateByPrimaryKeySelective(reTeamRepresentative);
    }

    @Override
    public List<Integer> getTrids(Integer tid) {
        return reTeamRepresentativeMapper.getTrids(tid);
    }
}
