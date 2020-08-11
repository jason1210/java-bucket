package com.jason.demo.es.service;

import com.jason.demo.es.model.Release;
import com.jason.demo.es.repository.ElasticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author: jason
 * @Date: 2020-08-03
 */
@Service
public class ElasticServiceImpl implements IElasticService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0, 10);

    @Override
    public void createIndex() {
        elasticsearchTemplate.indexOps(Release.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    @Override
    public void save(Release Release) {
        elasticRepository.save(Release);
    }

    @Override
    public void saveAll(List<Release> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public Iterator<Release> findAll() {
        return elasticRepository.findAll().iterator();
    }

    @Override
    public Page<Release> findByContentText(String contentText) {
        return elasticRepository.findByContentText(contentText, pageable);
    }

    @Override
    public Page<Release> query(String key) {
        return elasticRepository.findByContentText(key, pageable);
    }
}
