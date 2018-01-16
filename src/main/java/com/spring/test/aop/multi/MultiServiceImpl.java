package com.spring.test.aop.multi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by zhiyong.zhang on 2018/1/16.
 */
@Service
public class MultiServiceImpl implements MultiService {

    @Override
    public void test() {
        System.out.println("test---multi");
    }
}
