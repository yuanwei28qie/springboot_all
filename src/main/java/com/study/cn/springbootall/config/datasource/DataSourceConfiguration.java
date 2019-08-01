package com.study.cn.springbootall.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author huwei
 * @date 2019/7/22 14:23
 * <p> description:</>
 */
@Configuration
public class DataSourceConfiguration {
    /**
     *  第一个数据连接，默认优先级最高
     * @return DataSource
     */
    @Bean(name = "dataSourceFirst")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    @Primary
    public DataSource dataSourceFirst() {
        //这种方式的配置默认只满足spring的配置方式，如果使用其他数据连接（druid）,需要自己独立获取配置
        return DataSourceBuilder.create().build();
    }


    /**
     * 第二个数据源
     * @return DataSource
     */
    @Bean(name = "dataSourceSecond")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource dataSourceSecond() {
        return DataSourceBuilder.create().build();
    }


}
