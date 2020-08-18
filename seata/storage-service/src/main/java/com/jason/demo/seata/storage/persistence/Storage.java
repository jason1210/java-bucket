package com.jason.demo.seata.storage.persistence;

import lombok.Data;

@Data
public class Storage {
    private Integer id;

    private String commodityCode;

    private Integer count;

}