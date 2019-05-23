package com.zhangwei.decorator.passport;

import com.zhangwei.decorator.ResultMsg;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 5:57 PM
 * @since 1.0.0
 **/
public interface ISiginService {
    ResultMsg regist(String username, String password);

    ResultMsg login(String username, String password);
}
