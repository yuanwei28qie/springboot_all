package com.study.cn.springbootall.service;

import com.study.cn.springbootall.entity.Student;

/**
 * @author huWei
 * @date 2019/7/21 12:30
 * <p> description:
 */
public interface StudentService {
    /**
     * 学生详情
     * @param primaryId 学生主键
     * @return 学生类
     */
    Student findByIdThrow(Long primaryId);
}