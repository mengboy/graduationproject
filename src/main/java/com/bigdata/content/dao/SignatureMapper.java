package com.bigdata.content.dao;

import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.Signature;

import java.util.List;

public interface SignatureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Signature record);

    int insertSelective(Signature record);

    Signature selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Signature record);

    int updateByPrimaryKey(Signature record);

    List<Signature> list(Query query);

    int count();

    void upDelStatus(Integer id);
}