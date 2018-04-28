package com.bigdata.content.service.impl;

import com.bigdata.content.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

    @Override public String saveFile(MultipartFile file, String dir) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String[] imgName = file.getOriginalFilename().split("\\.");
        int len = imgName.length;
        try {
            if(len >= 2) {
                StringBuilder filePath = new StringBuilder().append(dir);
                //获取输出流
                File imgFile = new File(filePath.append(uuid).append(".").append(imgName[len - 1]).toString());
                if(!imgFile.exists())
                {
                    imgFile.createNewFile();
                }
                BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(imgFile));
                BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
                int temp;
                int length = 0;
                byte[] bb = new byte[1024];
                //一个一个字节的读取并写入
                while ((temp = bufferedInputStream.read(bb)) != (-1)) {
                    os.write(bb, 0, temp);
                    length += temp;
                }
                os.flush();
                os.close();
                bufferedInputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "文件不存在";
        }
        return "/" + uuid + "." + imgName[len - 1];
    }
}
