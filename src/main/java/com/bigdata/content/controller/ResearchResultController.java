package com.bigdata.content.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 研究成果
 */
@RestController
@RequestMapping("/content")
public class ResearchResultController {

    @GetMapping("/researchResult")
    @RequiresPermissions(("content:researchResult:researchResult"))
    String researchResult(){
        return "content/researchResult/researchResult";
    }


}
