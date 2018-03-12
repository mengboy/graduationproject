package com.bootdo.type.controller;


import com.bootdo.common.utils.R;
import com.bootdo.type.domain.About;
import com.bootdo.type.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class AboutController {

    @Autowired
    AboutService aboutService;

    @RequestMapping("")
    String mainPage(){
        return "type/about/main";
    }


    @RequestMapping("/save")
    @ResponseBody
    Object save(About about){
        if(about.getId() != null){
            aboutService.update(about);
        }else {
            aboutService.saveAbout(about);
        }
        return R.ok();
    }

    @RequestMapping("/select")
    @ResponseBody
    Object select(){
        Map<String, Object> map = new HashMap<>();
        map.put("about", aboutService.getAbout());
        return R.ok(map);
    }

}
