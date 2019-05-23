package com.zhangwei.jvm.chapter1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @create 2019-02-25 5:03 PM
 * @since 1.0.0
 **/
@RestController
public class MemoryController {
    private List<User> userList = new ArrayList<User>();
    private List<Class<?>>  classList = new ArrayList<Class<?>>();

    /**
     * -Xmx32M -Xms32M  堆溢出
     * */
    @GetMapping("/heap")
    public String heap() {
        int i=0;
        while(true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }


    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * */
    @GetMapping("/nonheap")
    public String nonheap() {
        while(true) {
            classList.addAll(Metaspace.createClasses());
        }
    }
}
