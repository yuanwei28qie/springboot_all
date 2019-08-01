package com.study.cn.springbootall.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author huwei
 * @date 2019/7/22 16:16
 * <p> description:</>
 */
@Data
@Entity
public class Person extends BaseEntity {

    /**
     * 姓名
     */
    private String name;
}
