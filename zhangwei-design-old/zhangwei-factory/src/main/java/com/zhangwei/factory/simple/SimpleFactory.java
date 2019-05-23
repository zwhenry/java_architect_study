package com.zhangwei.factory.simple;

import com.zhangwei.factory.Mengniu;
import com.zhangwei.factory.Milk;
import com.zhangwei.factory.Telunsu;
import com.zhangwei.factory.Yili;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-05 2:10 PM
 * @since 1.0.0
 **/
public class SimpleFactory {
    public Milk getMilk(String name){
        if("特仑苏".equals(name)){
            return new Telunsu();
        }else if("伊利".equals(name)){
            return new Yili();
        }else if("蒙牛".equals(name)){
            return new Mengniu();
        }else {
            System.out.println("不能生产您所需的产品");
            return null;
        }
    }
}
