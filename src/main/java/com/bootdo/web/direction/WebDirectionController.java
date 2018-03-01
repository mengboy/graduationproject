package com.bootdo.web.direction;

import com.bootdo.common.utils.R;
import com.bootdo.type.domain.CaseAnalysis;
import com.bootdo.type.domain.DiscussSpace;
import com.bootdo.type.domain.ResearchDirection;
import com.bootdo.type.domain.ShowProject;
import com.bootdo.type.service.DirectionCaseAnalysisService;
import com.bootdo.type.service.DirectionDiscussSpaceService;
import com.bootdo.type.service.DirectionShowProject;
import com.bootdo.type.service.ResearchDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bigdata/direction")
public class WebDirectionController {

    @Autowired
    ResearchDirectionService researchDirectionService;

    @Autowired
    DirectionShowProject directionShowProject;

    @Autowired
    DirectionCaseAnalysisService directionCaseAnalysisService;

    @Autowired
    DirectionDiscussSpaceService directionDiscussSpaceService;

    @GetMapping("/types")
    @ResponseBody
    Object getDirectionTypes(){
        List<ResearchDirection> researchDirections = null;
        try{
            researchDirections = researchDirectionService.getAllDirection();
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("results", researchDirections);
        return R.ok(map);
    }

    @GetMapping("/{rdid}")
    @ResponseBody
    Object getDirection(@PathVariable("rdid") Integer rdid){
        ResearchDirection researchDirection = null;
        try{
            researchDirection = researchDirectionService.selectById(rdid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("direction", researchDirection);
        return R.ok(map);
    }

    @GetMapping("/showProject/{rdid}")
    @ResponseBody
    Object getShowProject(@PathVariable("rdid") Integer rdid){
        List<ShowProject> showProjects = null;
        try{
            showProjects = directionShowProject.getShowProjectByRdID(rdid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("results", showProjects);
        return R.ok(map);
    }

    @GetMapping("/CaseAnalysis/{rdid}")
    @ResponseBody
    Object getCaseAnalysis(@PathVariable("rdid") Integer rdid){
        List<CaseAnalysis> caseAnalysisList = null;
        try{
            caseAnalysisList = directionCaseAnalysisService.getCaseAnalysisByRdID(rdid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        Map<String, Object> map = new HashMap<>();

        return R.ok(map);

    }

    @GetMapping("/discussSpace/{rdid}")
    @ResponseBody
    Object getDiscussSpace(@PathVariable("rdid") Integer rdid){
        List<DiscussSpace> discussSpaceList = null;
        try {
            discussSpaceList = directionDiscussSpaceService.getDiscussSpace(rdid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        Map<String, Object> map = new HashMap<>();

        return R.ok(map);
    }


}
