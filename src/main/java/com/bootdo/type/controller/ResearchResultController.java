package com.bootdo.type.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 研究成果
 */
@RestController
@RequestMapping("/type")
public class ResearchResultController {

    @GetMapping("/researchResult")
    @RequiresPermissions(("type:researchResult:researchResult"))
    String researchResult(){
        return "blog/type/researchResult/researchResult";
    }


}
