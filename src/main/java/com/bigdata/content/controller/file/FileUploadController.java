package com.bigdata.content.controller.file;

import com.bigdata.common.utils.R;
import com.bigdata.content.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/content/file")
public class FileUploadController {

    @Autowired FileUploadService fileUploadService;

    @Value("${image.upload.dir}")
    private String imageDir;

    @RequestMapping("/upImage")
    @ResponseBody
    public Object imageUpload(@RequestParam("img") MultipartFile file){
        System.out.println();

        if(file == null){
            return R.error();
        }

        String imgUrl = null;

        imgUrl = fileUploadService.saveFile(file, imageDir);

        Map<String, Object> map = new HashMap<>();
        map.put("url", imgUrl);

        return R.ok(map);
    }

}
