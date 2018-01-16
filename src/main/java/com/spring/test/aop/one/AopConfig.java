package com.spring.test.aop.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zhiyong.zhang on 2018/1/14.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.spring.test.aop.one")
public class AopConfig {

    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }
}
