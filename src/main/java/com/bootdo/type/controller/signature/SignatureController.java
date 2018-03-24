package com.bootdo.type.controller.signature;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.type.domain.Meeting;
import com.bootdo.type.domain.MeetingPeople;
import com.bootdo.type.domain.Signature;
import com.bootdo.type.service.MeetingPeopleService;
import com.bootdo.type.service.MeetingService;
import com.bootdo.type.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type/signature")
public class SignatureController {

    @Autowired
    SignatureService signatureService;

    @Autowired
    MeetingService meetingService;

    @Autowired
    MeetingPeopleService meetingPeopleService;



    @RequestMapping("")
    String signaturePage(){
        return "type/signature/signature";
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
        return R.ok("meeting", meeting);
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
        try{
            meetingPeopleService.select(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
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
