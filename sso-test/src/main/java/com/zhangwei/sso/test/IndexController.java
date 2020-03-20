package com.zhangwei.sso.test;

import com.danke.commons.sso.entity.SsoPrincipal;
import com.danke.commons.sso.entity.SsoUserPrincipal;
import com.danke.commons.sso.entity.SsoUserPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ${DESCRIPTION}
 *
 * @author zhangwei10
 * @date 2019-06-05 7:36 PM
 * @since 1.0.0
 **/
@Controller
public class IndexController {
    @GetMapping(value = "index")
    public String index() {
        return "welcome";
    }

    @GetMapping(value = "test")
    public String testLogin(HttpServletRequest request, Model model) {
        Integer currentUserId = (Integer) request.getAttribute("currentUserId");
        SsoPrincipal a = (SsoPrincipal) request.getUserPrincipal();
        model.addAttribute("test", a.getUserId());


        SsoUserPrincipal b= (SsoUserPrincipal) request.getUserPrincipal();
        model.addAttribute("test", b.getUserId());

        SsoUserPrincipal c = (SsoUserPrincipal) request.getUserPrincipal();
        model.addAttribute("test", c.getUserId());


        return "login";
    }
}
