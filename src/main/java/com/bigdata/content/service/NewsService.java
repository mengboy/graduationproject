package com.bigdata.content.service;

import com.bigdata.common.utils.Query;
import com.bigdata.content.domain.NewsType;

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
