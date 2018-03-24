package com.bootdo.type.dao;

import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.Signature;

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