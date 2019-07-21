package com.study.cn.springbootall.repository;

import com.study.cn.springbootall.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huWei
 * @date 2019/7/21 11:29
 * <p> description:
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}

