package com.spring.test.aop.multi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zhiyong.zhang on 2018/1/14.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.spring.test.aop.multi")
public class MulitiAopConfig {

    @Bean
    public Aspect1 findAspect1() {
        return new Aspect1();
    }

    @Bean
    public Aspect2 findAspect2() {
        return new Aspect2();
    }

    @Bean
    public Aspect3 findAspect3() {
        return new Aspect3();
    }
}
