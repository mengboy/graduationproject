package com.bigdata.content.controller.team;


import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.ReTeamRepresentative;
import com.bigdata.content.domain.TeamRepresentative;
import com.bigdata.content.service.ReTeamRepresentativeService;
import com.bigdata.content.service.TeamRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content/teamRepresentative")
public class TeamRepresentativeController {

    @Autowired
    TeamRepresentativeService teamRepresentativeService;

    @Autowired
    ReTeamRepresentativeService reTeamRepresentativeService;


    @GetMapping("")
    String addPage(){
        return "content/team/addTeamRepresentative";
    }



    @PostMapping("/save")
    @ResponseBody
    Object save(TeamRepresentative teamRepresentative){
        try{
            if(teamRepresentative.getTrid() == null){
                teamRepresentativeService.add(teamRepresentative);
                String teams = teamRepresentative.getTeams();
                if(teams != null && !teams.trim().equals("")){
                    String[] teamsArr = teams.trim().split(" ");
                    for(String t : teamsArr){
                        String[] tidAndtrid = t.split(":");
                        ReTeamRepresentative reTeamRepresentative = new ReTeamRepresentative();
                        reTeamRepresentative.settId(Integer.valueOf(tidAndtrid[0]));
                        reTeamRepresentative.setRepresentId(teamRepresentative.getTrid());
                        reTeamRepresentative.setOrderBy(Integer.valueOf(tidAndtrid[1]));
                        reTeamRepresentativeService.insert(reTeamRepresentative);
                    }
                }

            }else {
                teamRepresentativeService.update(teamRepresentative);
                //获取编辑后属于的团队
                String teams = teamRepresentative.getTeams();
                if(teams != null && !teams.trim().equals("")){
                    String[] teamsArr = teams.trim().split(" ");
                    for(String t : teamsArr){
                        String[] tidAndtrid = t.split(":");
                        ReTeamRepresentative reTeamRepresentative = new ReTeamRepresentative();
                        reTeamRepresentative.settId(Integer.valueOf(tidAndtrid[0]));
                        reTeamRepresentative.setRepresentId(teamRepresentative.getTrid());
                        reTeamRepresentative.setOrderBy(Integer.valueOf(tidAndtrid[1]));
                        if(Integer.valueOf(tidAndtrid[2]) == 0){
                            reTeamRepresentativeService.insert(reTeamRepresentative);
                        }else {
                            reTeamRepresentative.setRtrid(Integer.valueOf(tidAndtrid[2]));
                            reTeamRepresentativeService.up(reTeamRepresentative);
                        }

                    }
                }


                String removeIds = teamRepresentative.getRemoveIds();
                if(removeIds != null && !removeIds.trim().equals("")){
                    String[] removeIdsArr = removeIds.trim().split(" ");
                    for(String id : removeIdsArr){
                        reTeamRepresentativeService.del(Integer.valueOf(id));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("/teamRepresentatives")
    @ResponseBody
    Object getTeamRepresentatives(@RequestParam  Map<String, Object> params){
        // 查询列表数据
        Query query = new Query(params);

        List<TeamRepresentative> teamRepresentatives = teamRepresentativeService.teamRepresentatives(query);
        int total = teamRepresentativeService.count();

        if(params != null){
            int i = 1;
            for(TeamRepresentative teamRepresentative: teamRepresentatives){
                teamRepresentative.setSn(i);
                i++;
            }
        }

        return new PageUtils(teamRepresentatives, total);
    }

    @RequestMapping("/teamRepresentative")
    @ResponseBody
    Object getTeamRepresentative(@RequestParam Integer trid){
        TeamRepresentative t = null;
        try{
            t =  teamRepresentativeService.get(trid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("result", t);
        return R.ok(map);
    }

    @GetMapping("/edit/{trid}")
    String edit(@PathVariable("trid") Integer trid, Model model){
        TeamRepresentative teamRepresentative = teamRepresentativeService.get(trid);
        model.addAttribute("teamRepresentative", teamRepresentative);
        return "content/team/editTeamRepresentative";
    }

    @PostMapping("/remove")
    @ResponseBody
    Object remove(@RequestParam Integer trid){
        List<ReTeamRepresentative> reTeamRepresentatives = reTeamRepresentativeService.reTeamRepresentative(trid);
        try{
            teamRepresentativeService.del(trid);
            if(reTeamRepresentatives != null && reTeamRepresentatives.size() != 0){
                for(ReTeamRepresentative reTeamRepresentative : reTeamRepresentatives){
                    reTeamRepresentativeService.del(reTeamRepresentative.getRtrid());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.ok();
    }


}
