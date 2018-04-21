package com.bigdata.web.direction;

import com.bigdata.common.utils.R;
import com.bigdata.content.domain.CaseAnalysis;
import com.bigdata.content.domain.DiscussSpace;
import com.bigdata.content.domain.ResearchDirection;
import com.bigdata.content.domain.ShowProject;
import com.bigdata.content.service.DirectionCaseAnalysisService;
import com.bigdata.content.service.DirectionDiscussSpaceService;
import com.bigdata.content.service.DirectionShowProject;
import com.bigdata.content.service.ResearchDirectionService;
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

    /**
     * 获取研究方向种类
     * @return
     */
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

    /**
     * 根据id获取研究方向
     * @param rdid
     * @return
     */
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


    /**
     * 获取示例项目
     * @param rdid
     * @return
     */
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

    /**
     * 获取案例分析
     * @param rdid
     * @return
     */
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
        map.put("results", caseAnalysisList);
        return R.ok(map);

    }

    /**
     * 获取交流空间
     * @param rdid
     * @return
     */
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

        map.put("results", discussSpaceList);
        return R.ok(map);
    }


}
