package com.zhangwei.sprongbootchapter1.config;

import com.zhangwei.sprongbootchapter1.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @date 2019-05-26 2:06 PM
 * @since 1.0.0
 **/
@Configuration
//@ComponentScan(basePackageClasses = User.class)
//@ComponentScan("com.zhangwei")
@ComponentScan(basePackages = {"com.zhangwei.*"})
public class AppConfig {
//    @Bean(name="user")
//    public User initUser(){
//        User user=new User();
//        user.setId(1L);
//        user.setUserName("zhangwei");
//        user.setNote("test");
//        return user;
//    }
}
