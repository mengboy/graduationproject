package com.bootdo.web.recruitment;


import com.bootdo.common.utils.R;
import com.bootdo.type.domain.JobType;
import com.bootdo.type.domain.Position;
import com.bootdo.type.service.JobTypeService;
import com.bootdo.type.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bigdata/recruitment")
public class WebRecruitmentController {

    @Autowired
    JobTypeService jobTypeService;

    @Autowired
    PositionService positionService;

    @RequestMapping("/type")
    @ResponseBody
    Object getTypes(){
        List<JobType> jobTypes = null;
        try{
            jobTypes = jobTypeService.listJobType(new HashMap<>());
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("result", jobTypes);
        return R.ok(map);
    }

    @RequestMapping("/getPositionGroupByPlace")
    @ResponseBody
    Object getPositionByPlace(){
        List<Position> positions = null;
        List<String> workPlaces = null;
        Map<String, Object> positionsOfworkPlace = new HashMap<>();
        try{
            workPlaces = positionService.getWorkPlaces();
            if(workPlaces != null){
                for(String wordPlace : workPlaces){
                    positions = positionService.getPositionByPlace(wordPlace);
                    positionsOfworkPlace.put(wordPlace, positions);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("results", positionsOfworkPlace);
        return R.ok(map);
    }
}
