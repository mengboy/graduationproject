package com.bigdata.content.controller.solution;

import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.SolutionType;
import com.bigdata.content.service.SolutionTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/content/solution")
public class SolutionTypeController {

    @Autowired
    SolutionTypeService solutionTypeService;

    @GetMapping("")
    @RequiresPermissions("content:solution:solution")
    String solution(){
        return "content/solution/solution";
    }


    /**
     * 添加solutionType
     * @param solutionType
     * @return
     */
    @PostMapping("/addSolutionType")
    @ResponseBody
    Object addSolutionType(@RequestParam String solutionType){
        SolutionType s = new SolutionType();
        s.setSolutionType(solutionType);
        try{
            solutionTypeService.insert(s);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("/listSolutionType")
    @ResponseBody
    Object listSolutionType(@RequestParam Map<String, Object> map){
        Query query = new Query(map);
        List<SolutionType> solutionTypes = null;
        try{
            solutionTypes = solutionTypeService.list(query);
            int i = 1;
            for(SolutionType solutionType : solutionTypes){
                solutionType.setSn(i);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = solutionTypeService.count();

        return new PageUtils(solutionTypes, total);
    }


    @GetMapping("/solutionTypes")
    @ResponseBody
    Object solutionTypes(){
        List<SolutionType> solutionTypes = null;
        try{
            solutionTypes = solutionTypeService.list();
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }


        Map<String, Object> map = new HashMap<>();
        map.put("results", solutionTypes);

        return R.ok(map);
    }

    @PostMapping("/delSolutionType")
    @ResponseBody
    Object delSolutionType(@RequestParam Integer id){
        try {
            solutionTypeService.del(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }

}
