package com.bootdo.type.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 研究团队
 */
@RestController
@RequestMapping("/type")
public class TeamController {


    @GetMapping("/team")
    @RequiresPermissions("type:team:team")
    String team(){
        return "blog/type/team/team";
    }


}
