package com.bigdata.content.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public String saveFile(MultipartFile file, String path);
}
