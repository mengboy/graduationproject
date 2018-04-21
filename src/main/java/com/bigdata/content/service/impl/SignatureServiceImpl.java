package com.bigdata.content.service.impl;

import com.bigdata.common.utils.Query;
import com.bigdata.content.dao.SignatureMapper;
import com.bigdata.content.domain.Signature;
import com.bigdata.content.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("signatureService")
public class SignatureServiceImpl implements SignatureService{


    @Autowired
    SignatureMapper signatureMapper;

    @Override
    public void insert(Signature signature) {
        signatureMapper.insertSelective(signature);
    }

    @Override
    public void update(Signature signature) {
        signatureMapper.updateByPrimaryKeySelective(signature);
    }

    @Override
    public void del(Integer id) {
        signatureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void select(Integer id) {
        signatureMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Signature> list(Query query) {
        return signatureMapper.list(query);
    }

    @Override
    public int count() {
        return signatureMapper.count();
    }

    @Override
    public void upDelStatus(Integer id) {
        signatureMapper.upDelStatus(id);
    }
}
