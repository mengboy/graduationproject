package com.bigdata.content.controller;


import com.bigdata.common.utils.PageUtils;
import com.bigdata.common.utils.Query;
import com.bigdata.common.utils.R;
import com.bigdata.content.domain.DataDownload;
import com.bigdata.content.service.DataDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content/dataDownload")
public class DataDownloadController {


    @Autowired
    DataDownloadService dataDownloadService;

    @GetMapping("")
    String dataDownload(){
        return "content/data/data";
    }

    @GetMapping("/list")
    @ResponseBody
    Object getDataDownloadList(@RequestParam Map<String, Object> params){
        // 查询列表数据
        Query query = new Query(params);

        List<DataDownload> dataDownloads = dataDownloadService.getDataDownloads(query);
        int total = dataDownloadService.count(query);

        if(params != null){
            int i = 1;
            for(DataDownload dataDownload: dataDownloads){
                dataDownload.setSn(i);
                i++;
            }
        }

        return new PageUtils(dataDownloads, total);
    }

    @PostMapping("/add")
    @ResponseBody
    Object addDataDownload(@RequestParam String desc, @RequestParam String url){
        DataDownload dataDownload = new DataDownload();
        dataDownload.setDownUrl(url);
        dataDownload.setDataDec(desc);
        try{
            dataDownloadService.addDataDownload(dataDownload);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }

    @PostMapping("/remove")
    @ResponseBody
    Object delDataDownload(@RequestParam Integer id){
        try{
            dataDownloadService.delDataDown(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }

    @PostMapping("/batchRemove")
    @ResponseBody
    Object batchRemove(@RequestParam("ids[]") Integer[] ids){
        try{
            for(Integer i : ids){
                dataDownloadService.delDataDown(i);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }

        return R.ok();
    }
}
