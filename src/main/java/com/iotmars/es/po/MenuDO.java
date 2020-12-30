package com.iotmars.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author: xsh
 * @date: 2020/12/28 9:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "menu")
public class MenuDO implements Serializable {

    private static final long serialVersionUID = -8996140203797336914L;
    /**
     * 菜谱id
     */
    @Id
    private Integer id;

    /**
     * 菜谱名称
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;

    /**
     * 菜谱描述
     */
    @Field(type = FieldType.Text)
    private String description;

    /**
     * 菜谱食材清单
     */
    @Field(type = FieldType.Text)
    private String tags;




















}
