package com.study.cn.springbootall.repository;

import com.study.cn.springbootall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huWei
 * @date 2019/7/21 11:29
 * <p> description:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 查询用户
     * @param userName 用户姓名
     * @return 用户
     */
    User findByUsername(String userName);
}
