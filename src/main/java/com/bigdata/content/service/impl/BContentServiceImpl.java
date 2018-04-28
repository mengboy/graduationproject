package com.bigdata.content.service.impl;

import com.bigdata.content.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bigdata.content.dao.BContentMapper;
import com.bigdata.content.domain.BContentDO;
import com.bigdata.content.service.BContentService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class BContentServiceImpl implements BContentService {
	@Autowired
	private BContentMapper bContentMapper;

	@Autowired FileUploadService fileUploadService;

	
	@Override
	public BContentDO get(Long cid){
		return bContentMapper.get(cid);
	}
	
	@Override
	public List<BContentDO> list(Map<String, Object> map){
		return bContentMapper.list(map);
	}

	@Override
	public List<BContentDO> news(Map<String, Object> map) {
		return bContentMapper.news(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return bContentMapper.count(map);
	}
	
	@Override
	public int save(BContentDO bContent){
		return bContentMapper.save(bContent);
	}
	
	@Override
	public int update(BContentDO bContent){
		return bContentMapper.update(bContent);
	}
	
	@Override
	public int remove(Long cid){
		return bContentMapper.remove(cid);
	}
	
	@Override
	public int batchRemove(Long[] cids){
		return bContentMapper.batchRemove(cids);
	}



}
