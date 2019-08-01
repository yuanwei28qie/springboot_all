package com.study.cn.springbootall.repository;

import com.study.cn.springbootall.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huwei
 * @date 2019/7/22 16:17
 * <p> description:</>
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
