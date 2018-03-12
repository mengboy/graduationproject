package com.bootdo.type.service.impl;

import com.bootdo.type.dao.AboutMapper;
import com.bootdo.type.domain.About;
import com.bootdo.type.service.AboutService;
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
