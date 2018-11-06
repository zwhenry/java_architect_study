package com.zhangwei.proxy.staticed;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-06 2:20 PM
 * @since 1.0.0
 **/
public class Father {
    private Son son;

    //没办法扩展
    public Father(Son son) {
        this.son = son;
    }

    public void findLove() {
        System.out.println("根据你的要求物色");
        this.son.findLove();
        System.out.println("双方父母是不是同意");
    }
}
