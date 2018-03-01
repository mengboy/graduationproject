package com.bootdo.type.domain;

public class ShowProject {
    private Integer spid;

    private String projectName;

    private Integer rsdId;

    private String projectInfo;

    private Integer snid;

    private String rsdName;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getRsdId() {
        return rsdId;
    }

    public void setRsdId(Integer rsdId) {
        this.rsdId = rsdId;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo == null ? null : projectInfo.trim();
    }

    public Integer getSnid() {
        return snid;
    }

    public void setSnid(Integer snid) {
        this.snid = snid;
    }

    public String getRsdName() {
        return rsdName;
    }

    public void setRsdName(String rsdName) {
        this.rsdName = rsdName;
    }
}