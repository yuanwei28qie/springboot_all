package com.study.cn.springbootall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author huWei
 * @date 2019/7/21 12:57
 * <p> description:
 */
@Configuration
public class InjectOpreator implements AuditorAware<String> {

    /**
     * 给Bean中的 @CreatedBy  @LastModifiedBy 注入操作人
     * @return name
     */
    @Override
    public Optional<String> getCurrentAuditor() {

        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            return null;
        }
        if (ctx.getAuthentication() == null) {
            return null;
        }else{
            String loginUserName = ctx.getAuthentication().getName();
            Optional<String> name = Optional.ofNullable(loginUserName);
            return name;
        }
    }
}