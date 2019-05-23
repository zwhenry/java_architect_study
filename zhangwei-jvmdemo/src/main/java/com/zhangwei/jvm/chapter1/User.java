package com.zhangwei.jvm.chapter1;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2019-02-25 5:04 PM
 * @since 1.0.0
 **/
public class User {
    private int id;
    private String name;
    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
