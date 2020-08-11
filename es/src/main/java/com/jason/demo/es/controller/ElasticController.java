package com.jason.demo.es.controller;

import com.jason.demo.es.model.Release;
import com.jason.demo.es.service.IElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: jason
 * @Date: 2020-08-03
 */
@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private IElasticService elasticService;

    @GetMapping("/init")
    public void init() {
        elasticService.createIndex();
        List<Release> list = new ArrayList<>();
        list.add(Release.builder().id(1L).contentText("niahoasadasd").build());
        list.add(Release.builder().id(2L).contentText("那就飒飒").build());
        list.add(Release.builder().id(3L).contentText("打打瞌睡但是但是多").build());
        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<Release> all() {
        return elasticService.findAll();
    }

}