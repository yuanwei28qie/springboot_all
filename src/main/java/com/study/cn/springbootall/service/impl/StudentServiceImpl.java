package com.study.cn.springbootall.service.impl;

import com.study.cn.springbootall.entity.Student;
import com.study.cn.springbootall.exception.BusinessException;
import com.study.cn.springbootall.repository.StudentRepository;
import com.study.cn.springbootall.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huWei
 * @date 2019/7/21 12:30
 * <p> description:
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Resource
    private StudentRepository repository;

    /**
     * 查询学生主键
     */
    @Override
    public Student findByIdThrow(Long primaryId){
        return repository.findById(primaryId).orElseThrow(()->new BusinessException("没有学生信息"));
    }
}