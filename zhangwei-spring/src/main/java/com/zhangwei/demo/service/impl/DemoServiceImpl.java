package com.zhangwei.demo.service.impl;

import com.zhangwei.demo.service.DemoService;
import com.zhangwei.zwframework.annotion.ZWService;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-10-30 1:18 PM
 * @since 1.0.0
 **/
@ZWService
public class DemoServiceImpl implements DemoService {
    @Override
    public String getName(String name) {
        return "Hello "+name;
    }

    @Override
    public int add(String name) {
        return 1;
    }
}
