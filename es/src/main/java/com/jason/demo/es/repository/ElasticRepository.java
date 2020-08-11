package com.jason.demo.es.repository;

import com.jason.demo.es.model.Release;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: jason
 * @Date: 2020-08-03
 */
public interface ElasticRepository extends ElasticsearchRepository<Release, Long> {
    //默认的注释
    Page<Release> findByContentText(String contentText, Pageable pageable);

}
