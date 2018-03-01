package com.bootdo.type.controller.solution;


import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.type.domain.Solution;
import com.bootdo.type.service.SolutionService;
import com.bootdo.type.service.SolutionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 解决方案
 */
@Controller
@RequestMapping("/type/solution")
public class SolutionController {


    @Autowired
    SolutionService solutionService;

    @Autowired
    SolutionTypeService solutionTypeService;


    @GetMapping("/addSolution")
    String addSolution(){
        return "type/solution/addSolution";
    }


    @PostMapping("/saveSolution")
    @ResponseBody
    Object saveSolution(Solution solution){
        try{
            if(solution.getSid() == null){
                solutionService.insertSolution(solution);
            }else {
                solutionService.upSolution(solution);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/listSolution")
    @ResponseBody
    public Object listSolution(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Solution> solutions = null;
        try{
            solutions = solutionService.solutions(query);
            int i = 1;
            for(Solution solution : solutions){
                solution.setSn(i);
                solution.setSolutionType(solutionTypeService.select(solution.getStid()).getSolutionType());
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = solutionService.count();

        return new PageUtils(solutions, total);
    }


    @PostMapping("/delSolution")
    @ResponseBody
    Object delSolution(@RequestParam Integer id){
        try{
            solutionService.delSolution(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }


    @PostMapping("/selectSolution")
    @ResponseBody
    Object selectSolution(@RequestParam Integer id){
        try{
            solutionService.getSolutionById(id);
        }catch (Exception e){
            return R.error();
        }

        return R.ok();
    }

    @GetMapping("/editSolution/{sid}")
    String edit(@PathVariable("sid") Integer sid, Model model) {
        Solution solution = solutionService.getSolutionById(sid);
        model.addAttribute("solution", solution);
        return "type/solution/editSolution";
    }
}
