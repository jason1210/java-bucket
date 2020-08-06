package com.jason.demo.es.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(indexName = "jason-es", type = "release2", shards = 1, replicas = 0)
public class Release {

    private Long id;

    private Long creatorId;

    private Long topicTypeId;

    private Date createTime;

    private Byte status;

    /**
     * 文件顺序数据，以json数组格式保存，[{"fileId":1,"order":1},{"fileId":2,"order":2}]
     */
    private String fileIdOrders;

    @Field(type = FieldType.Keyword)
    private String contentText;

    private Integer likes;

    private Integer reviews;

    private Integer schoolId;

    /**
     * 上传视频时返回的traceId
     */
    private String traceId;

    public Release(Long id, Integer likes) {
        this.id = id;
        this.likes = likes;
    }
}