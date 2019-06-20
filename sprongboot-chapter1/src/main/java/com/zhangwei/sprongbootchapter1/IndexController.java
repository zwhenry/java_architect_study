package com.zhangwei.sprongbootchapter1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @date 2019-05-26 1:46 PM
 * @since 1.0.0
 **/
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
