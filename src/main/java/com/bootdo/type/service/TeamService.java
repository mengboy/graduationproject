package com.bootdo.type.service;

import com.bootdo.type.domain.Team;

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
