package com.bootdo.type.service;



import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.Signature;

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
