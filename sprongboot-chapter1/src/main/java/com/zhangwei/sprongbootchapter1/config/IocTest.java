package com.zhangwei.sprongbootchapter1.config;


import com.zhangwei.sprongbootchapter1.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @date 2019-05-26 2:09 PM
 * @since 1.0.0
 **/

public class IocTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.getId());
    }
}
