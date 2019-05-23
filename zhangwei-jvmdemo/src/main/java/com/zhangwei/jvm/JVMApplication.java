package com.zhangwei.jvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2019-02-25 3:12 PM
 * @since 1.0.0
 **/
@SpringBootApplication
public class JVMApplication extends SpringBootServletInitializer {

    /**
     * -Xmx32M -Xms32M
     * */
    public static void main(String[] args) {
        SpringApplication.run(JVMApplication.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JVMApplication.class);
    }
}
