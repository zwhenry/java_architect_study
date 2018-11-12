package com.zhangwei.adapter.passport;

import com.zhangwei.adapter.bean.Member;
import com.zhangwei.adapter.ResultMsg;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 5:42 PM
 * @since 1.0.0
 **/
public class SiginService {
    /**
     * 注册方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password) {
        System.out.println("regist原有方法内容");
        return new ResultMsg("200", "注册成功", new Member());
    }


    /**
     * 登录的方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password) {
        System.out.println("login原有方法内容");
        return null;
    }
}
