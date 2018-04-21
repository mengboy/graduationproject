package com.bigdata.content.service;

import com.bigdata.content.domain.ReTeamRepresentative;

import java.util.List;

public interface ReTeamRepresentativeService {

    List<ReTeamRepresentative> reTeamRepresentative(Integer trid);

    int insert(ReTeamRepresentative reTeamRepresentative);

    int del(Integer id);

    /**
     * 查询代表属于那些团队
     * @param trId
     * @return
     */
    List<ReTeamRepresentative> rtrId(Integer trId);

    void up(ReTeamRepresentative reTeamRepresentative);

    List<Integer> getTrids(Integer tid);
}
