package com.bigdata.web.about;


import com.bigdata.common.utils.R;
import com.bigdata.content.domain.About;
import com.bigdata.content.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/bigdata")
public class WebAboutController {

    @Autowired
    AboutService aboutService;

    @GetMapping("/getAbout")
    @ResponseBody
    Object getAbout(){
        About about = aboutService.getAbout();
        Map<String, Object> map = new HashMap<>();
        map.put("about", about);
        return R.ok(map);
    }

}
