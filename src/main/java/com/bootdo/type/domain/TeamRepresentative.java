package com.bootdo.type.domain;

public class TeamRepresentative {
    private Integer trid;

    private String represenAvatar;

    private String info;

    private String direction;

    private Integer sn;

    private String name;

    private String teams;

    private String removeIds;

    private String infoUrl;

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public String getRepresenAvatar() {
        return represenAvatar;
    }

    public void setRepresenAvatar(String represenAvatar) {
        this.represenAvatar = represenAvatar == null ? null : represenAvatar.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getRemoveIds() {
        return removeIds;
    }

    public void setRemoveIds(String removeIds) {
        this.removeIds = removeIds;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }
}