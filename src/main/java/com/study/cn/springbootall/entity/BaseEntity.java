package com.study.cn.springbootall.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author huWei
 * @date 2019/7/21 11:34
 * <p> description: 基本信息的代码
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class BaseEntity implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 自动插入操作人
     */
    @CreatedBy
    private String createBy;
    /**
     * 自动插入操作时间
     */
    @CreatedDate
    private LocalDateTime createDate;
    /**
     * 自动插入操作人
     */
    @LastModifiedBy
    private String updateBy;
    /**
     * 有修改时 会自动更新时间
     */
    @LastModifiedDate
    private LocalDateTime updateDate;
    /**
     * 0 物理删除  1 逻辑删除
     */
    private Boolean enabled;
}