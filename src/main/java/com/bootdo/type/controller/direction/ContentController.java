package com.bootdo.type.controller.direction;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.type.domain.CaseAnalysis;
import com.bootdo.type.domain.DiscussSpace;
import com.bootdo.type.domain.ShowProject;
import com.bootdo.type.service.DirectionCaseAnalysisService;
import com.bootdo.type.service.DirectionDiscussSpaceService;
import com.bootdo.type.service.DirectionShowProject;
import com.bootdo.type.service.ResearchDirectionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/direction/content")
public class ContentController {


    @Autowired
    DirectionShowProject directionShowProject;

    @Autowired
    ResearchDirectionService researchDirectionService;

    @Autowired
    DirectionCaseAnalysisService directionCaseAnalysisService;

    @Autowired
    DirectionDiscussSpaceService directionDiscussSpaceService;

    @RequestMapping("")
    String showProject(){
        return "type/direction/direction";
    }


    /**
     * 添加交流空间
     * @return
     */
    @GetMapping("/addDiscussSpace")
    String addDiscussSpace(){
        return "type/direction/addDiscussSpace";
    }


    /**
     * 添加案例分析
     * @param
     * @return
     */
    @GetMapping("/addCaseAnalysis")
    String addCaseAnalysis(){
        return "type/direction/addCaseAnalysis";
    }


    @GetMapping("/addShowProjectPage")
    String addShowProjectPage(){
        return "type/direction/addShowProject";
    }

    /**
     * 保存
     * @return
     */
    @PostMapping("/addShowProject")
    @ResponseBody
    @RequiresPermissions("type:direction:contentadd")
    Object addContent(ShowProject showProject){
        if(showProject.getSpid() == null){
            try{
                directionShowProject.insertShowProject(showProject);
            }catch (Exception e){
                e.printStackTrace();
                return R.error("保存失败");
            }
        }else {
            try{
                directionShowProject.upShowProject(showProject);
            }catch (Exception e){
                e.printStackTrace();
                return R.error("保存失败");
            }
        }
        return R.ok("保存成功");
    }


    @GetMapping("/showProjects")
    @ResponseBody
    Object getShowProjects(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<ShowProject> directionShowProjects = null;
        try{
            directionShowProjects = directionShowProject.selectShowProjects(query);
            int i = 1;
            for(ShowProject showProject : directionShowProjects){
                showProject.setSnid(i);
                showProject.setRsdName(researchDirectionService.selectById(showProject.getRsdId()).getName());
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = directionShowProject.count();

        return new PageUtils(directionShowProjects, total);
    }

    @GetMapping("/editShowProject/{did}")
    @RequiresPermissions("type:direction:edit")
    String edit(@PathVariable("did") Integer did, Model model) {
        ShowProject showProject = directionShowProject.selectShowProject(did);
        model.addAttribute("showProject", showProject);
        return "type/direction/editShowProject";
    }

    @PostMapping("/showPoject")
    @ResponseBody
    Object getShowPorject(@RequestParam Integer id){
        ShowProject showProject = null;
        try{
            showProject = directionShowProject.selectShowProject(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("project", showProject);
        return R.ok(map);
    }

    @PostMapping("/delShowProject")
    @ResponseBody
    Object delShowProject(@RequestParam Integer id){
        try{
            directionShowProject.delShowProject(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }


    /**
     * 保存案例分析
     * @param caseAnalysis
     * @return
     */
    @PostMapping("/saveCaseAnalysis")
    @ResponseBody
    Object saveCaseAnalysis(CaseAnalysis caseAnalysis){
        if(caseAnalysis.getCaid() == null){
            try{
                directionCaseAnalysisService.insertCaseAnalysis(caseAnalysis);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }else {
            try{
                directionCaseAnalysisService.upCaseAnalysis(caseAnalysis);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }
        return R.ok();
    }


    /**
     * 分页查询案例分析
     * @param params
     * @return
     */
    @GetMapping("/listCaseAnalysis")
    @ResponseBody
    Object getListCaseAnalysis(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<CaseAnalysis> caseAnalysisList = null;
        try{
            caseAnalysisList = directionCaseAnalysisService.getCaseAnalysisList(query);
            int i = 1;
            for(CaseAnalysis caseAnalysis : caseAnalysisList){
                caseAnalysis.setSnid(i);
                caseAnalysis.setRsdName(researchDirectionService.selectById(caseAnalysis.getRsdId()).getName());
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = directionCaseAnalysisService.count();

        return new PageUtils(caseAnalysisList, total);
    }

    @PostMapping("/delCaseAnalysis")
    @ResponseBody
    Object delCaseAnalysis(@RequestParam Integer id){
        try{
            directionCaseAnalysisService.delCaseAnalysis(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }

    /**
     * 查询案例分析
     * @param id
     * @return
     */
    @PostMapping("/selectCaseAnalysis")
    @ResponseBody
    Object selectCaseAnalysis(@RequestParam Integer id){

        CaseAnalysis caseAnalysis = null;

        try{
            directionCaseAnalysisService.getCaseAnalysis(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();

        return R.ok(map);
    }



    /**
     * 保存案例分析
     * @param discussSpace
     * @return
     */
    @PostMapping("/saveDiscussSpace")
    @ResponseBody
    Object saveDiscussSpace(DiscussSpace discussSpace){
        if(discussSpace.getDsid() == null){
            try{
                directionDiscussSpaceService.insert(discussSpace);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }else {
            try{
                directionDiscussSpaceService.upCaseAnalysis(discussSpace);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }
        return R.ok();
    }


    /**
     * 分页查询案例分析
     * @param params
     * @return
     */
    @GetMapping("/listDiscussSpace")
    @ResponseBody
    Object listDiscussSpace(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<DiscussSpace> discussSpaceList = null;
        try{
            discussSpaceList = directionDiscussSpaceService.list(query);
            int i = 1;
            for(DiscussSpace discussSpace : discussSpaceList){
                discussSpace.setSnid(i);
                discussSpace.setRsdName(researchDirectionService.selectById(discussSpace.getRsdId()).getName());
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = directionDiscussSpaceService.count();

        return new PageUtils(discussSpaceList, total);
    }

    @PostMapping("/delDiscussSpace")
    @ResponseBody
    Object delDiscussSpace(@RequestParam Integer id){
        try{
            directionDiscussSpaceService.del(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }



}
