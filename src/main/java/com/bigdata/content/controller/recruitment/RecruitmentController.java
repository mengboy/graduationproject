package com.bigdata.content.controller.recruitment;


import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.JobType;
import com.bigdata.content.domain.Position;
import com.bigdata.content.service.JobTypeService;
import com.bigdata.content.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content/recruitment")
public class RecruitmentController {

    @Autowired
    JobTypeService jobTypeService;

    @Autowired
    PositionService positionService;



    @RequestMapping("")
    String mainPage(){
        return "content/recruitment/recruitment";
    }


    @RequestMapping("/saveType")
    @ResponseBody
    Object saveType(JobType jobType){
        try{
            if(jobType.getJtId() == null){
                jobTypeService.insertJobType(jobType);
            }else {
                jobTypeService.updateJobType(jobType);
            }

        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }


    @RequestMapping("/getTypeById")
    @ResponseBody
    Object getTypeById(@RequestParam Integer id){
        Map<String, Object> map = new HashMap<>();
        map.put("type", jobTypeService.selectType(id));
        return R.ok(map);
    }

    @RequestMapping("/delType")
    @ResponseBody
    Object delType(@RequestParam Integer id){
        jobTypeService.delJobType(id);
        return R.ok();
    }


    @RequestMapping("/listTypePage")
    @ResponseBody
    Object listTypePage(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<JobType> jobTypes = null;
        try{
            jobTypes = jobTypeService.listJobType(query);
            int i = 1;
            for(JobType jobType : jobTypes){
                jobType.setSn(i);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = jobTypeService.count();
        return new PageUtils(jobTypes, total);
    }

    @RequestMapping("/listTypes")
    @ResponseBody
    Object listTypes(){
        List<JobType> jobTypes = null;
        try{
            jobTypes = jobTypeService.listJobType(new HashMap<>());
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("results", jobTypes);
        return R.ok(map);
    }

    @RequestMapping("/savePosition")
    @ResponseBody
    Object savePosition(Position position){
        try{
            if(position.getpId() == null){
                java.util.Date ud = new java.util.Date();
                Date date = new Date(ud.getTime());
                position.setCreateDate(date);
                positionService.insertPosition(position);
            }else {
                positionService.updatePosition(position);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/delPosition")
    @ResponseBody
    Object delPosition(@RequestParam Integer id){
        positionService.delPosition(id);
        return R.ok();
    }

    @RequestMapping("/listPosition")
    @ResponseBody
    Object listPosition(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Position> positions = null;
        try{
            positions = positionService.listPosition(query);
            int i = 1;
            for(Position position : positions){
                position.setSn(i);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = jobTypeService.count();
        return new PageUtils(positions, total);
    }

    @GetMapping("/addPosition")
    String addPositionPage(){
        return "content/recruitment/addPosition";
    }

    @PostMapping("/editPosition")
    @ResponseBody
    Object editPositionPage(@RequestParam Integer id){
        Position position = positionService.getPosition(id);
        Map<String, Object> map = new HashMap<>();
        map.put("position", position);
        return R.ok(map);
    }
}
