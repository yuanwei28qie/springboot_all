package com.study.cn.springbootall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author huwei
 * @date 2019年7月21日11点32分
 */
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAllApplication.class, args);
	}

}
