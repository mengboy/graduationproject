package com.bootdo.type.service;

import com.bootdo.type.domain.About;

public interface AboutService {
    About getAbout();

    int saveAbout(About about);

    int update(About about);
}
