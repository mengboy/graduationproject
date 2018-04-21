package com.bigdata.content.controller.direction;


import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.ResearchDirection;
import com.bigdata.content.service.ResearchDirectionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 研究方向
 */
@Controller
@RequestMapping("/content/direction")
public class DirectionController {

    @Autowired
    ResearchDirectionService researchDirectionService;

    @GetMapping("")
    @RequiresPermissions("content:direction:direction")
    String direction(){
        return "content/direction/direction";
    }


    @GetMapping("/addPage")
    String editPage(){
        return "content/direction/addDirection";
    }

    /**
     * 插入
     * @return
     */
    @PostMapping("/save")
    @RequiresPermissions("content:direction:edit")
    @ResponseBody
    public Object add(ResearchDirection researchDirection){
        if(researchDirection.getDid() == null){
            try{
                researchDirectionService.add(researchDirection);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }else {
            try{
                researchDirectionService.update(researchDirection);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }


        return R.ok();
    }






    @GetMapping("/edit/{did}")
    @RequiresPermissions("content:direction:edit")
    String edit(@PathVariable("did") Integer did, Model model) {
        ResearchDirection researchDirection = researchDirectionService.selectById(did);
        model.addAttribute("researchDirection", researchDirection);
        return "content/direction/editDirection";
    }


    @RequestMapping("/remove")
    @RequiresPermissions("content:direction:remove")
    @ResponseBody
    public Object remove(@RequestParam("id") Integer id){
        try{
            researchDirectionService.del(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }


    @RequestMapping("/batchRemove")
    @RequiresPermissions("content:direction:batchRemove")
    @ResponseBody
    public Object batchRemove(@RequestParam("ids[]") Integer[] ids){
        try{
            for(Integer id : ids){
                researchDirectionService.del(id);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }

    @RequestMapping("/list")
    @ResponseBody
    public Object list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<ResearchDirection> researchDirections = null;
        try{
            researchDirections = researchDirectionService.list(query);
            int i = 1;
            for(ResearchDirection researchDirection : researchDirections){
                researchDirection.setSn(i);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        int total = researchDirectionService.count();


        return new PageUtils(researchDirections, total);
    }

    @GetMapping("/directions")
    @ResponseBody
    public Object getDirections(){
        List<ResearchDirection> researchDirections = null;
        try{
            researchDirections = researchDirectionService.getDirections();
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("results", researchDirections);
        return R.ok(map);
    }

}
