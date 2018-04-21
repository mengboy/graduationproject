package com.bigdata.content.service;

import com.bigdata.content.domain.BContentDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
public interface BContentService {
	
	BContentDO get(Long cid);
	
	List<BContentDO> list(Map<String, Object> map);

	List<BContentDO> news(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BContentDO bContent);
	
	int update(BContentDO bContent);
	
	int remove(Long cid);
	
	int batchRemove(Long[] cids);

	String saveImage(MultipartFile file);
}
