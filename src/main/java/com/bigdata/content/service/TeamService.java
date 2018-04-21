package com.bigdata.content.service;

import com.bigdata.content.domain.Team;

import java.util.List;
import java.util.Map;

public interface TeamService {

    List<Team> teams(Map<String, Object> map);

    int insertTeam(Team team);

    int upTeam(Team team);

    int delTeam(Integer id);

    Team getTeam(Integer id);

    int count();




}
