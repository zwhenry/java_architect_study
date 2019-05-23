package com.zhangwei.decorator.upgrade;

import com.zhangwei.decorator.ResultMsg;
import com.zhangwei.decorator.passport.ISiginService;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 6:01 PM
 * @since 1.0.0
 **/
public interface ISigninForThirdService extends ISiginService {
    public ResultMsg loginForQQ(String openId);

    public ResultMsg loginForWechat(String openId);

    public ResultMsg loginForToken(String token);

    public ResultMsg loginForTelphone(String telphone, String code);

    public ResultMsg loginForRegist(String username,String password);
}
