package com.zhangwei.observer.mouse;

import com.zhangwei.observer.core.EventLisenter;

/**
 * 被观察者
 * 如果做过Swing开发的话，有一种似曾相识的感觉
 *
 * @author zhangwei10
 * @create 2018-11-12 6:35 PM
 * @since 1.0.0
 **/
public class Mouse extends EventLisenter {

    public void click(){
        System.out.println("鼠标单击");
        this.trigger(MouseEventType.ON_CLICK);
    }


    public void doubleClick(){
        System.out.println("鼠标双击");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up(){
        System.out.println("鼠标弹起");
        this.trigger(MouseEventType.ON_UP);
    }

    public void down(){
        System.out.println("鼠标按下");
        this.trigger(MouseEventType.ON_DOWN);
    }


    public void wheel(){
        System.out.println("鼠标滚动");
        this.trigger(MouseEventType.ON_WHEEL);
    }

    public void move(){
        System.out.println("鼠标移动");
        this.trigger(MouseEventType.ON_MOVE);
    }

    public void over(){
        System.out.println("鼠标悬停");
        this.trigger(MouseEventType.ON_OVER);
    }
}
