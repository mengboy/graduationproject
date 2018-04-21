package com.bigdata.content.domain;

import java.util.Date;

public class DataDownload {
    private Integer ddid;

    private String dataDec;

    private String downUrl;

    private Integer sn;

    private Date publishTime;

    public Integer getDdid() {
        return ddid;
    }

    public void setDdid(Integer ddid) {
        this.ddid = ddid;
    }

    public String getDataDec() {
        return dataDec;
    }

    public void setDataDec(String dataDec) {
        this.dataDec = dataDec == null ? null : dataDec.trim();
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl == null ? null : downUrl.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }
}