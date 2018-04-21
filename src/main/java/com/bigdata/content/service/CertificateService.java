package com.bigdata.content.service;

import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.Certificate;

import java.util.List;

public interface CertificateService {
    void insert(Certificate certificate);

    void update(Certificate certificate);

    void upDelStatus(Integer id);

    Certificate selectById(Integer id);

    int count();

    List<Certificate> list(Query query);
}
