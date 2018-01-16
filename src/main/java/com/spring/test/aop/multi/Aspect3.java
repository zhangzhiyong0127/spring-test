package com.spring.test.aop.multi;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * Created by zhiyong.zhang on 2018/1/16.
 */
@Aspect
@Order(1)
public class Aspect3 {

    @Pointcut("execution(* com.spring.test.aop.multi.MultiServiceImpl.*(..))")
    public void pointCut(){}


    @Before("pointCut()")
    public void before(){
        System.out.println("Aspect3  before...................");
    }
}
