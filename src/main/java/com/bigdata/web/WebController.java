package com.bigdata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bigdata")
public class WebController {
    /**
     * 网站首页
     * @return
     */
    @GetMapping("")
    String bigdata(){
        return "web/index";
    }

    /**
     * 动态消息
     * @return
     */
    @GetMapping("/newscenter")
    String newscenter(){
        return "web/newscenter/index";
    }

    @GetMapping("/content")
    String newsContent(){
        return "web/newscenter/content";
    }

    /**
     * 研究方向
     */
    @GetMapping("/direction")
    String direction(){
        return "web/direction/index";
    }

    /**
     * 研究团队
     * @return
     */
    @GetMapping("/teams")
    String teams(){
        return "web/teams/index";
    }

    /**
     * 研究成果
     * @return
     */
    @GetMapping("/achievments")
    String achievments(){
        return "web/achievments/index";
    }

    /**
     * 解决方案
     * @return
     */
    @GetMapping("/solution")
    String solution(){
        return "web/solution/index";
    }

    /**
     * 文件下载
     * @return
     */
    @GetMapping("/download")
    String download(){
        return "web/download/index";
    }

    /**
     * 关于我们
     * @return
     */
    @GetMapping("/about")
    String about(){
        return "web/about/index";
    }

    /**
     * 人才招聘
     * @return
     */
    @GetMapping("/job")
    String job(){
        return "web/job/index";
    }

    /**
     * 专题查询
     * @return
     */
    @GetMapping("/theme")
    String theme(){
        return "web/theme/index";
    }


//          <li class="navitem"><a href="type/yjfx.html">研究方向</a></li>
//          <li class="navitem"><a href="teams/yjtd1.html">研究团队</a></li>
//          <li class="navitem"><a href="achievments/yjcg.html">研究成果</a></li>
//          <li class="navitem"><a href="solution/jjfa.html">解决方案</a></li>
//          <li class="navitem"><a href="download/zlxz.html">资料下载</a></li>
//          <li class="navitem"><a href="about/adout-us.html">关于我们</a></li>
}
