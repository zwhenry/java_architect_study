package com.zhangwei.decorator.upgrade;

import com.zhangwei.decorator.ResultMsg;
import com.zhangwei.decorator.passport.ISiginService;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 6:02 PM
 * @since 1.0.0
 **/
public class SigninForThirdService implements ISigninForThirdService {

    private ISiginService service;

    public SigninForThirdService(ISiginService service) {
        this.service = service;
    }

    public ResultMsg regist(String username, String password) {
        return service.regist(username, password);
    }

    public ResultMsg login(String username, String password) {
        return service.login(username, password);
    }

    public ResultMsg loginForQQ(String openId) {
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
        return null;
    }

    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    public ResultMsg loginForRegist(String username, String password) {
        this.regist(username, null);
        return this.login(username, null);
    }

}
