package com.study.cn.springbootall.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
@Table(name = "Sys_Role", schema = "springsecurity", catalog = "")
public class Role extends BaseEntity {
    /**
     * 姓名
     */
    private String name;
    /**
     * 角色用户
     */
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
    /**
     * 角色权限
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Sys_permission_role",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    private List<Permission> permissions = new ArrayList<>();







}
