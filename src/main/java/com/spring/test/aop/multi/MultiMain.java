package com.spring.test.aop.multi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhiyong.zhang on 2018/1/14.
 */
public class MultiMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MulitiAopConfig.class);

        MultiService multiService = context.getBean(MultiService.class);

        multiService.test();


    }
}
