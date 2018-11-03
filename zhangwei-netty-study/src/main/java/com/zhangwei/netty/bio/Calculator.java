package com.zhangwei.netty.bio;

import lombok.extern.slf4j.Slf4j;

/**
 * 计算器
 *
 * @author zhangwei10
 * @create 2018-11-03 2:23 PM
 * @since 1.0.0
 **/
@Slf4j
public class Calculator {
    public static int cal(String expression) throws Exception {
        char op = expression.charAt(1);
        switch (op) {
            case '+':
                return (expression.charAt(0) - 48) + (expression.charAt(2) - 48);
            case '-':
                return (expression.charAt(0) - 48) - (expression.charAt(2) - 48);
            case '*':
                return (expression.charAt(0) - 48) * (expression.charAt(2) - 48);
            case '/':
                return (expression.charAt(0) - 48) / (expression.charAt(2) - 48);
        }
        throw new Exception("Calculator error");
    }
}
