package com.spring.test.aop.one;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhiyong.zhang on 2018/1/14.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        RoleService roleService = context.getBean(RoleService.class);

        roleService.printRole("role1", "role2");


    }
}
