package com.study.cn.springbootall.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @author huwei
 * @date 2019/7/22 14:24
 * <p> description:</> com.study.cn.springbootall.repository
 */
/**
 * 第一个数据源，jpa的相关配置
 */
@Configuration
@EntityScan(basePackages = "com.study.cn.springbootall.entity")
//1、实体扫描
//2、实体管理ref
//3、事务管理
@EnableJpaRepositories(
        basePackages = "com.study.cn.springbootall.repository",
        entityManagerFactoryRef = "firstEntityManagerFactoryBean",
        transactionManagerRef = "firstTransactionManager")
@EnableTransactionManagement
public class JpaFirstConfiguration {
    //第一个数据源，可以不加Qualifier
    @Autowired
    @Qualifier("dataSourceFirst")
    private DataSource dataSource;

    //jpa其他参数配置
    @Autowired
    private JpaProperties jpaProperties;

    //实体管理工厂builder
    @Autowired
    private EntityManagerFactoryBuilder factoryBuilder;

    /**
     * 配置第一个实体管理工厂的bean
     * @return
     */
    @Primary
    @Bean(name = "firstEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(
            EntityManagerFactoryBuilder builder, JpaProperties jpaProperties,
            HibernateProperties hibernateProperties) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder.dataSource(dataSource).properties(properties)
                .packages("com.study.cn.springbootall.entity").build();
    }

    /**
     * EntityManager不过解释，用过jpa的应该都了解
     * @return
     */
    @Bean(name = "firstEntityManager")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder,JpaProperties jpaProperties,
                                       HibernateProperties hibernateProperties) {
        return entityManagerFactorySecondary(builder,jpaProperties,hibernateProperties).getObject().createEntityManager();
    }

    /**
     * jpa事务管理
     * @return
     */
    @Bean(name = "firstTransactionManager")
    @Primary
    public JpaTransactionManager transactionManager(EntityManagerFactoryBuilder builder,JpaProperties jpaProperties,
                                                    HibernateProperties hibernateProperties) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactorySecondary(builder,jpaProperties,hibernateProperties).getObject());
        return jpaTransactionManager;
    }
}
