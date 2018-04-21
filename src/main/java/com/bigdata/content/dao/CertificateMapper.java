package com.bigdata.content.dao;

import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.Certificate;

import java.util.List;

public interface CertificateMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Certificate record);

    int insertSelective(Certificate record);

    Certificate selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Certificate record);

    int updateByPrimaryKey(Certificate record);

    void upDelStatus(Integer cid);

    List<Certificate> list(Query query);

    int count();
}