package com.bootdo.web.team;


import com.bootdo.common.utils.R;
import com.bootdo.type.domain.Team;
import com.bootdo.type.domain.TeamRepresentative;
import com.bootdo.type.service.ReTeamRepresentativeService;
import com.bootdo.type.service.TeamRepresentativeService;
import com.bootdo.type.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bigdata/team")
public class WebTeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    ReTeamRepresentativeService reTeamRepresentativeService;

    @Autowired
    TeamRepresentativeService teamRepresentativeService;

    @GetMapping("/teams")
    @ResponseBody
    Object getTeams(){
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

    @PostMapping("/team")
    @ResponseBody
    Object getTeam(@RequestParam Integer tid){
        Team team = null;
        try{
            team = teamService.getTeam(tid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("team", team);
        return R.ok(map);
    }

    /**
     * 根据团队id获取团队代表
     * @param tid
     * @return
     */
    @PostMapping("/teamRepresentatives")
    @ResponseBody
    Object getTeamRepresentatives(@RequestParam Integer tid){
        List<Integer> trids = null;
        List<TeamRepresentative> teamRepresentatives = new ArrayList<>();
        try{
            trids = reTeamRepresentativeService.getTrids(tid);
            for(Integer id : trids){
                TeamRepresentative teamRepresentative = teamRepresentativeService.get(id);
                teamRepresentatives.add(teamRepresentative);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("results", teamRepresentatives);

        return R.ok(map);

    }

}
