package com.zhangwei.observer.mouse;

import com.zhangwei.observer.core.Event;

import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2018-11-12 6:37 PM
 * @since 1.0.0
 **/
public class MouseTest {
    public static void main(String[] args) {
        /*
         * var input = document.getElementById("username");
         * input.addLisenter("click",function(){
         *
         *     alert("鼠标点击了这个文本框");
         *
         * });
         *
         *
         * */

        //观察者和被观察者之间没有必然联系
        //注册的时候，才产生联系


        //解耦


        try {

            //创建观察者
            MouseEventCallback callback = new MouseEventCallback();
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);


            //人为的调用鼠标的单击事件
            Mouse mouse = new Mouse();
            //注入监听 只有监听了才是观察者模式
            mouse.addLisenter(MouseEventType.ON_CLICK, callback,onClick);

            mouse.click();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
