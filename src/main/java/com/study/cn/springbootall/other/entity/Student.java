package com.study.cn.springbootall.other.entity;

import com.study.cn.springbootall.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author huWei
 * @date 2019/7/21 11:29
 * <p> description:
 */
@Getter
@Setter
@Entity
public class Student extends BaseEntity {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 班级
     */
    private Integer classId;
    /**
     * 父母
     */
    private String partnerId;
    /**
     * 关系
     */
    private Integer relationShip;

}