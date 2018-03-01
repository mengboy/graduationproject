package com.bootdo.type.domain;

public class SolutionType {
    private Integer stid;

    private String solutionType;

    public Integer getStid() {
        return stid;
    }

    private Integer sn;

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getSolutionType() {
        return solutionType;
    }

    public void setSolutionType(String solutionType) {
        this.solutionType = solutionType == null ? null : solutionType.trim();
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }
}