package com.bigdata.content.controller.signature;

import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.Meeting;
import com.bigdata.content.domain.MeetingPeople;
import com.bigdata.content.service.MeetingPeopleService;
import com.bigdata.content.service.MeetingService;
import com.bigdata.content.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content/signature")
public class SignatureController {

    @Autowired
    SignatureService signatureService;

    @Autowired
    MeetingService meetingService;

    @Autowired
    MeetingPeopleService meetingPeopleService;



    @RequestMapping("")
    String signaturePage(){
        return "content/signature/signature";
    }


    @RequestMapping("/saveMeeting")
    @ResponseBody
    Object saveMeeting(Meeting meeting){

        try{
            if(meeting.getmId() == null){
                meeting.setIsDel("0");
                meetingService.insert(meeting);
            }else {
                meetingService.update(meeting);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delMeeting")
    @ResponseBody
    Object delMeeting(@RequestParam Integer id){
        try{
            meetingService.upDelStatus(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/selectMeetingById")
    @ResponseBody
    Object selectMeetingById(@RequestParam  Integer id){
        Meeting meeting = null;
        try{
            meeting = meetingService.select(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok("result", meeting);
    }

    @RequestMapping("/selectMeetingPages")
    @ResponseBody
    Object selectMeetingPages(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Meeting> meetingList = null;
        try{
            meetingList = meetingService.list(query);
            int i = 1;
            for(Meeting meeting : meetingList){
                meeting.setSn(i);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = meetingService.count();

        return new PageUtils(meetingList, total);
    }

    @RequestMapping("/listMeeting")
    @ResponseBody
    Object listMeeting(){
        List<Meeting> meetingList = null;
        try{
            meetingList = meetingService.list(new HashMap());
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok("results", meetingList);
    }



    @RequestMapping("/saveMeetingPeople")
    @ResponseBody
    Object saveMeetingPeople(MeetingPeople meetingPeople){

        try{
            if(meetingPeople.getMpId() == null){
                meetingPeople.setIsDel("0");
                meetingPeopleService.insert(meetingPeople);
            }else {
                meetingPeopleService.update(meetingPeople);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delMeetingPeople")
    @ResponseBody
    Object delMeetingPeople(@RequestParam Integer id){
        try{
            meetingPeopleService.upDelStatus(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/selectMeetingPeopleById")
    @ResponseBody
    Object selectMeetingPeopleById(@RequestParam  Integer id){
        MeetingPeople m = null;
        try{
            m = meetingPeopleService.select(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok("result", m);
    }

    @RequestMapping("/selectMeetingPeoplePages")
    @ResponseBody
    Object selectMeetingPeoplePages(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<MeetingPeople> meetingPeopleList = null;
        try{
            meetingPeopleList = meetingPeopleService.list(query);
            int i = 1;
            for(MeetingPeople meetingPeople : meetingPeopleList){
                meetingPeople.setMeeting(meetingService.select(meetingPeople.getmId()).getMeeting());
                meetingPeople.setSn(i);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = meetingPeopleService.count();
        return new PageUtils(meetingPeopleList, total);
    }
}
