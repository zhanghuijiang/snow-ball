package com.web.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 * @author arvin
 */
@Controller
public class IndexController {
	
	@RequestMapping("home")
    public ModelAndView home(HttpServletRequest request) {
       return new ModelAndView("home");
    }
}

