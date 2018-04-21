package com.bigdata.content.service;

import com.bigdata.content.domain.About;

public interface AboutService {
    About getAbout();

    int saveAbout(About about);

    int update(About about);
}
