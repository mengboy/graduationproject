package com.bigdata.content.service;

import com.bigdata.content.domain.ShowProject;

import java.util.List;
import java.util.Map;

public interface DirectionShowProject {
    int insertShowProject(ShowProject showProject);

    int delShowProject(Integer Id);

    List<ShowProject> selectShowProjects(Map<String, Object> map);

    ShowProject selectShowProject(Integer id);

    int upShowProject(ShowProject showProject);

    int count();

    List<ShowProject> getShowProjectByRdID(Integer rdid);
}
