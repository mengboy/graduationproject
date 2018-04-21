package com.bigdata.content.domain;

public class JobType {
    private Integer jtId;

    private String jtName;

    private String jtDesc;

    private Integer  sn;

    public Integer getJtId() {
        return jtId;
    }

    public void setJtId(Integer jtId) {
        this.jtId = jtId;
    }

    public String getJtName() {
        return jtName;
    }

    public void setJtName(String jtName) {
        this.jtName = jtName == null ? null : jtName.trim();
    }

    public String getJtDesc() {
        return jtDesc;
    }

    public void setJtDesc(String jtDesc) {
        this.jtDesc = jtDesc == null ? null : jtDesc.trim();
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }
}