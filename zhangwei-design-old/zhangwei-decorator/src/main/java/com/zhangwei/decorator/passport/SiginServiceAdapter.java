package com.zhangwei.decorator.passport;

import com.zhangwei.decorator.ResultMsg;

/**
 * 适配器 可以继承 也可以注入
 *
 * @author zhangwei10
 * @create 2018-11-12 5:44 PM
 * @since 1.0.0
 **/
public class SiginServiceAdapter extends SiginService {


    public ResultMsg loginForQQ(String openId) {
        System.out.println("loginForQQ适配器模式方法内容");
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）
        //4、调用原来的登录方法
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String token) {
        //通过token拿到用户信息，然后再重新登陆了一次
        return null;
    }

    public ResultMsg loginForTelphone(String telphone, String code) {

        return null;
    }

    public ResultMsg loginForRegist(String username, String password) {
        super.regist(username, null);
        return super.login(username, null);
    }
}
