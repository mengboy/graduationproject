package com.bigdata.content.service;



import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.Signature;

import java.util.List;

public interface SignatureService {
    void insert(Signature signature);

    void update(Signature signature);

    void del(Integer id);

    void select(Integer id);

    List<Signature> list(Query query);

    int count();

    void upDelStatus(Integer id);
}
