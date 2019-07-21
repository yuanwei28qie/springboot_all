package com.study.cn.springbootall.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huWei
 * @date 2019/7/21 11:29
 * <p> description:
 */
@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Table(name = "Sys_permission", schema = "springsecurity", catalog = "")
public class Permission extends BaseEntity{
    /**
     * 姓名
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 可以访问的url
     */
    private String url;
    /**
     * pid
     */
    private Integer pid;
    /**
     * 多个角色
     */
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles = new ArrayList<>();

















}
