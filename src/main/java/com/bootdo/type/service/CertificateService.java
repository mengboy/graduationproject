package com.bootdo.type.service;

import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.Certificate;

import java.util.List;

public interface CertificateService {
    void insert(Certificate certificate);

    void update(Certificate certificate);

    void upDelStatus(Integer id);

    Certificate selectById(Integer id);

    int count();

    List<Certificate> list(Query query);
}
