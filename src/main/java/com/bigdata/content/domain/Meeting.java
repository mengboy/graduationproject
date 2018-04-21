package com.bigdata.content.domain;

public class Meeting {
    private Integer mId;

    private String meeting;

    private String meetingtime;

    private String meetingaddr;

    private String remark;

    private String isDel;

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    private Integer sn;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting == null ? null : meeting.trim();
    }

    public String getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(String meetingtime) {
        this.meetingtime = meetingtime == null ? null : meetingtime.trim();
    }

    public String getMeetingaddr() {
        return meetingaddr;
    }

    public void setMeetingaddr(String meetingaddr) {
        this.meetingaddr = meetingaddr == null ? null : meetingaddr.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}