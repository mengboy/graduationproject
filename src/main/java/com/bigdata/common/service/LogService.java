package com.bigdata.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bigdata.common.domain.SysLogDO;
import com.bigdata.common.domain.PageDO;
import com.bigdata.common.utils.Query;
@Service
public interface LogService {
	PageDO<SysLogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(List<Long> ids);
}
