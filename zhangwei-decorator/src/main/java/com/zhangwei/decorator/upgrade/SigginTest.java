package com.zhangwei.decorator.upgrade;

import com.zhangwei.decorator.passport.SiginService;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 6:05 PM
 * @since 1.0.0
 **/
public class SigginTest {
    public static void main(String[] args) {
        //原来的功能依旧对外开放，依旧保留
        //新的功能同样的也可以使用

        ISigninForThirdService signinForThirdService = new SigninForThirdService(new SiginService());

        signinForThirdService.loginForQQ("xxssdsd");


//        Decorator
//        Wrapper


        /*

            ===============================================================------
            装饰器模式                          |   适配器模式
            -----------------------------------+---------------------------------
            是一种非常特别的适配器模式            |  可以不保留层级关系
            -----------------------------------+---------------------------------
            装饰者和被装饰者都要实现同一个接口     |  适配者和被适配者没有必然的层级联系
            主要目的是为了扩展，依旧保留OOP关系    |  通常采用代理或者继承形式进行包装
            -----------------------------------+----------------------------------
            满足is-a的关系                      |   满足has-a
            -----------------------------------+----------------------------------
            注重的是覆盖、扩展                   |   注重兼容、转换
            -----------------------------------+----------------------------------


        */

        //为了某个实现类在不修改原始类的基础上进行动态地覆盖或者增加方法
        //该实现保持跟原有类的层级关系
        //采用装饰模式
        //装饰器模式实际上一种非常特殊的适配器模式

        //虽然 DataInputStream 功能更强大
        //DataInputStream 同样要实现InputStream
        InputStream in = null;
        FilterInputStream fis = new DataInputStream(in);

    }
}
