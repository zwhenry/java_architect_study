package com.zhangwei.delegate.leader;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 6:25 PM
 * @since 1.0.0
 **/
public class TargetA implements ITarget {
    public void doing(String command) {
        System.out.println("我是员工A，我现在开始干" + command + "工作");
    }
}
