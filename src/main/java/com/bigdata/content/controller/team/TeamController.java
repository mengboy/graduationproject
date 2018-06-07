package com.bigdata.content.controller.team;


import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.Team;
import com.bigdata.content.service.TeamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content/team")
public class TeamController {


    @Autowired
    TeamService teamService;

    @GetMapping("")
    String index(){
        return "content/team/index";
    }

    @GetMapping("/addTeam")
    String addTeam(){
        return "content/team/addTeam";
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
        return "content/team/editTeam";
    }
}
