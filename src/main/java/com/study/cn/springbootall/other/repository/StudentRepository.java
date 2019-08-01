package com.study.cn.springbootall.other.repository;

import com.study.cn.springbootall.other.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huwei
 * @date 2019/7/22 15:14
 * <p> description:</>
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
