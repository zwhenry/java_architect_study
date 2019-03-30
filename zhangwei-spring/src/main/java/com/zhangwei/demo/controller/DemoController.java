package com.zhangwei.demo.controller;

import com.zhangwei.demo.service.DemoService;
import com.zhangwei.zwframework.annotion.ZWAutowired;
import com.zhangwei.zwframework.annotion.ZWController;
import com.zhangwei.zwframework.annotion.ZWRequestMapping;
import com.zhangwei.zwframework.annotion.ZWRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-10-30 1:21 PM
 * @since 1.0.0
 **/
@ZWController
@ZWRequestMapping("/demo")
public class DemoController {
    @ZWAutowired
    private DemoService demoService;

    @ZWRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      String name){
        String result=demoService.getName(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ZWRequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse resp,
                    @ZWRequestParam("a") Integer a, @ZWRequestParam("b") Integer b){
        try {
            resp.getWriter().write(a + "+" + b + "=" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ZWRequestMapping("/remove")
    public void remove(HttpServletRequest req,HttpServletResponse resp,
                       @ZWRequestParam("id") Integer id){
    }
}
