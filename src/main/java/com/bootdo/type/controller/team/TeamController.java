package com.bootdo.type.controller.team;


import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.type.domain.Team;
import com.bootdo.type.service.TeamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type/team")
public class TeamController {


    @Autowired
    TeamService teamService;

    @GetMapping("")
    @RequiresPermissions("type:team:team")
    String team(){
        return "/type/team/team";
    }

    @GetMapping("/addTeam")
    @RequiresPermissions("type:team:add")
    String addTeam(){
        return "type/team/addTeam";
    }



    @GetMapping("/teams")
    @ResponseBody
    Object getTeams(@RequestParam Map<String, Object> params){
        // 查询列表数据
        Query query = new Query(params);

        List<Team> teamList = teamService.teams(query);
        int total = teamService.count();

        if(params != null){
            int i = 1;
            for(Team team: teamList){
                team.setSn(i);
                i++;
            }
        }

        return new PageUtils(teamList, total);
    }


    @GetMapping("/all")
    @ResponseBody
    Object getAllTeam(){
        List<Team> teams = null;
        try{
            teams = teamService.teams(new HashMap<>());
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("results", teams);
        return R.ok(map);
    }

    @PostMapping("/save")
    @ResponseBody
    Object addTeam(Team team){
        if(team.getTid() == null){
            try{
                teamService.insertTeam(team);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }else {
            try{
                teamService.upTeam(team);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
        }

        return R.ok();
    }

    @PostMapping("/remove")
    @ResponseBody
    Object remove(@RequestParam Integer tid){
        try{
            teamService.delTeam(tid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }

    @PostMapping("/batchRemove")
    @ResponseBody
    Object batchRemove(@RequestParam("ids[]") Integer[] ids){
        try{
            for(Integer id : ids){
                teamService.delTeam(id);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error("批量删除失败");
        }
        return R.ok();
    }

    @GetMapping("/edit/{tid}")
    String edit(@PathVariable("tid") Integer tid, Model model) {
        Team team = teamService.getTeam(tid);
        model.addAttribute("team", team);
        return "type/team/editTeam";
    }
}
