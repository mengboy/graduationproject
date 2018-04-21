package com.bigdata.content.service.impl;

import com.bigdata.content.dao.AboutMapper;
import com.bigdata.content.domain.About;
import com.bigdata.content.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("aboutService")
public class AboutServiceImpl implements AboutService{

    @Autowired
    AboutMapper aboutMapper;

    @Override
    public About getAbout() {
        return aboutMapper.select();
    }

    @Override
    public int saveAbout(About about) {
        return aboutMapper.insertSelective(about);
    }

    @Override
    public int update(About about) {
        return aboutMapper.updateByPrimaryKeySelective(about);
    }
}
