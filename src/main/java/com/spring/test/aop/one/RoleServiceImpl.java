package com.spring.test.aop.one;

import org.springframework.stereotype.Service;

/**
 * Created by zhiyong.zhang on 2018/1/14.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(String role,String role2) {
        System.out.println(role+"------" + role2);
    }
}
