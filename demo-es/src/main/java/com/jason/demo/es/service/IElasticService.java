package com.jason.demo.es.service;

import com.jason.demo.es.model.Release;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

/**
 * @author: jason
 * @Date: 2020-08-03
 */
public interface IElasticService {
    void createIndex();

    void deleteIndex(String index);

    void save(Release docBean);

    void saveAll(List<Release> list);

    Iterator<Release> findAll();

    Page<Release> findByContentText(String contentText);

    Page<Release> query(String key);
}
