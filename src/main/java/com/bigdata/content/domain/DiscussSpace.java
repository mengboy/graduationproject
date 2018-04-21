package com.bigdata.content.domain;

public class DiscussSpace {
    private Integer dsid;

    private String imageUrl;

    private String spaceUrl;

    private String description;

    private Integer rsdId;

    private Integer snid;

    private String rsdName;

    public Integer getDsid() {
        return dsid;
    }

    public void setDsid(Integer dsid) {
        this.dsid = dsid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getSpaceUrl() {
        return spaceUrl;
    }

    public void setSpaceUrl(String spaceUrl) {
        this.spaceUrl = spaceUrl == null ? null : spaceUrl.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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