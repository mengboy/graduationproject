package com.bootdo.type.service;

import com.bootdo.common.utils.Query;
import com.bootdo.type.domain.NewsType;

import java.util.List;

public interface NewsService {
    int addNewsType(NewsType newsType);

    int removeNewsType(Integer id);

    List<NewsType> list(Query query);

    int count(Query query);

    NewsType selectNewsTypeById(Integer id);

    void editNewsType(NewsType newsType);

    List<NewsType> getTypes();
}
