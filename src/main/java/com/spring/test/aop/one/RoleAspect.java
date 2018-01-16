package com.spring.test.aop.one;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by zhiyong.zhang on 2018/1/14.
 */

@Aspect
@Order(1)//多个切面配置顺序
public class RoleAspect {

//    @Before("execution(* com.spring.test.aop.RoleServiceImpl.printRole(..))")
//    public void before(){
//        System.out.println("before...................");
//    }


    @Pointcut("execution(* com.spring.test.aop.one.RoleServiceImpl.*(..))")
    public void pointCut(){

    }


    @Before("pointCut()")
    public void before(){
        System.out.println("before...................");
    }


    @After("pointCut()")
    public void after(){
        System.out.println("after................");
    }

    @AfterReturning("pointCut()")
    public void afterReturing(){
        System.out.println("afterReturing................");
    }


    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing................");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint){

        try {
            System.out.println("around before...................");
            Object[] args = joinPoint.getArgs();
            System.out.println(args);

            Signature signature = joinPoint.getSignature();


            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            String name = method.getName();
            Parameter[] parameters = method.getParameters();
            System.out.println(parameters);
            RequestMapping requestMapping  = method.getAnnotation(RequestMapping.class);
//            requestMapping.params();
//            requestMapping.path();
//            requestMapping.value();
//            requestMapping.name();
            System.out.println("around after...................");
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }


    /**
     * 切面传递参数
     * @author zhiyong.zhang
     * @date 2018/1/14 16:48
     */

    @Before("execution(* com.spring.test.aop.one.RoleServiceImpl.*(..)) && args(args1,args2)")
    public void printArgs(String args1,String args2){
        System.out.println("printArgs---------------传递的参数是：" + args1 + args2);
    }


   /*
    xml配置方式
    <bean id="permissionAdvice" class="com.lincomb.report.common.advice.PermissionAdvice" />
    <aop:config>
        <aop:aspect id="aspect" ref="permissionAdvice">
            <aop:pointcut id="pointUserMgr" expression="execution(* com.lincomb.report.controller.*.*(..))"/>
            <aop:around method="doAround"  pointcut-ref="pointUserMgr"/>
        </aop:aspect>
    </aop:config>
   */


/*
    public class PermissionAdvice {

        public Object doAround(ProceedingJoinPoint pp) throws Throwable {
            MethodSignature methodSignature = (MethodSignature)pp.getSignature();
            Method method = methodSignature.getMethod();
            RequestMapping requestMapping  = method.getAnnotation(RequestMapping.class);
            Permission permission = method.getAnnotation(Permission.class);
            if(requestMapping == null) {
                return pp.proceed();
            }

            if(permission == null) {
                throw new RuntimeException("方法:" + methodSignature.toString()+"必须添加注解(方便权限控制):com.lincomb.report.common.annotation.Permission" );
            }

            return pp.proceed();
        }

    }*/
}
