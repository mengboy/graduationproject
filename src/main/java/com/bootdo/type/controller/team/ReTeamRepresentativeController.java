package com.bootdo.type.controller.team;


import com.bootdo.common.utils.R;
import com.bootdo.type.domain.ReTeamRepresentative;
import com.bootdo.type.service.ReTeamRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type/reTeamRepresentative")
public class ReTeamRepresentativeController {

    @Autowired
    ReTeamRepresentativeService reTeamRepresentativeService;

    @PostMapping("/getReTeamRepresentatives")
    @ResponseBody
    Object getReTeamRepresentatives(@RequestParam Integer trid){
        List<ReTeamRepresentative> reTeamRepresentatives = null;
        try{
            reTeamRepresentatives = reTeamRepresentativeService.reTeamRepresentative(trid);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();

        map.put("results", reTeamRepresentatives);

        return R.ok(map);
    }


}
