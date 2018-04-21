package com.bigdata.content.service;

import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.DataDownload;

import java.util.List;
import java.util.Map;

public interface DataDownloadService {

    List<DataDownload> getDataDownloads(Map<String, Object> map);

    int addDataDownload(DataDownload dataDownload);

    int delDataDown(Integer id);

    int count(Query query);
}
