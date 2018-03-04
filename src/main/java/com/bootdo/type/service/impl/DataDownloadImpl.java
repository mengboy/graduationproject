package com.bootdo.type.service.impl;

import com.bootdo.common.utils.Query;
import com.bootdo.type.dao.DataDownloadMapper;
import com.bootdo.type.domain.DataDownload;
import com.bootdo.type.service.DataDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("dataDownload")
public class DataDownloadImpl implements DataDownloadService{


    @Autowired
    DataDownloadMapper dataDownloadMapper;

    @Override
    public List<DataDownload> getDataDownloads(Map<String, Object> map) {
        return dataDownloadMapper.list(map);
    }

    @Override
    public int addDataDownload(DataDownload dataDownload) {
        return dataDownloadMapper.insertSelective(dataDownload);
    }

    @Override
    public int delDataDown(Integer id) {
        return dataDownloadMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int count(Query query) {
        return dataDownloadMapper.count();
    }
}
