package com.bootdo.type.controller;


import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.NewsType;
import com.bootdo.type.service.NewsService;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 动态消息
 */
@Controller
@RequestMapping("/type/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("")
    @RequiresPermissions("type:news:news")
    String newsType(){
        return "type/news/news";
    }


    /**
     * 获取消息分类
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("type:news:news")
    public Object list(@RequestParam Map<String, Object> params) {

        // 查询列表数据
        Query query = new Query(params);

        List<NewsType> typeNewsList = newsService.list(query);
        int total = newsService.count(query);

        if(typeNewsList != null){
            int i = 1;
            for(NewsType newsType: typeNewsList){
                newsType.setSn(i);
                i++;
            }
        }

        return new PageUtils(typeNewsList, total);
    }

    @ResponseBody
    @GetMapping("/types")
    public Object getTypes(){
        List<NewsType> newsTypes = null;
        try{
            newsTypes = newsService.getTypes();
        }catch (Exception e){
            return R.error();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("types", newsTypes);
        return R.ok(map);
    }

    @PostMapping("/type")
    @ResponseBody
    @RequiresPermissions("type:news:news")
    public Object getNewsTypeById(@RequestParam("id") Integer id){
        NewsType newsType = null;

        try{
            newsType = newsService.selectNewsTypeById(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("type", newsType);

        return R.ok(map);
    }

    @GetMapping("/add")
    @RequiresPermissions("type:news:news")
    String newsTypeAddPage(){
        return "type/news/add";
    }

    /**
     * 添加分类
     * @param type
     * @return
     */
    @PostMapping("/add")
    @RequiresPermissions("type:news:add")
    @ResponseBody
    public Object addNewsType(@RequestParam("type") String type){
        NewsType newsType = new NewsType();
        newsType.setTypeName(type);
        try{
            newsService.addNewsType(newsType);
        }catch (Exception e){
            e.printStackTrace();
            return R.error("添加失败");
        }
        return R.ok("添加成功");
    }


    @PostMapping("/edit")
    @RequiresPermissions("type:news:edit")
    @ResponseBody
    public Object editNewsType(@RequestParam("id") Integer id, @RequestParam("type") String type){
        if(id != null && type != null ){
            NewsType newsType = new NewsType();
            newsType.setNtId(id);
            newsType.setTypeName(type);
            try{
                newsService.editNewsType(newsType);
            }catch (Exception e){
                e.printStackTrace();
                return R.error();
            }
            return R.ok();
        }else {
            return R.error();
        }
    }


    @PostMapping("/remove")
    @RequiresPermissions(("type:news:remove"))
    @ResponseBody
    public Object removeNewsType(@RequestParam("id") Integer id){
        try{
            newsService.removeNewsType(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error("删除失败");
        }
        return R.ok("删除成功");
    }

    @PostMapping("/batchRemove")
    @RequiresPermissions(("type:news:batchRemove"))
    @ResponseBody
    public Object batchRemoveNewsType(@RequestParam("ids[]") Integer[] ids){
        try{
            for(Integer id : ids){
                newsService.removeNewsType(id);
            }
        }catch (Exception e){
            return R.error("批量删除失败");
        }

        return R.ok("删除成功");
    }

}
