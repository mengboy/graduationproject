package com.bootdo.type.domain;

public class CaseAnalysis {
    private Integer caid;

    private String title;

    private String caseUrl;

    private Integer rsdId;

    private Integer snid;

    private String rsdName;

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCaseUrl() {
        return caseUrl;
    }

    public void setCaseUrl(String caseUrl) {
        this.caseUrl = caseUrl == null ? null : caseUrl.trim();
    }

    public Integer getRsdId() {
        return rsdId;
    }

    public void setRsdId(Integer rsdId) {
        this.rsdId = rsdId;
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