package com.zhangwei.zwframework.annotion;

import java.lang.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-10-30 1:49 PM
 * @since 1.0.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZWAutowired {
    String value() default "";
}
