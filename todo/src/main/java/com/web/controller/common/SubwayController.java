package com.web.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 跳转路由
 * @author arvin
 */
@Controller
public class SubwayController {
	
	@RequestMapping("togo")
    public String todoIndex(@RequestParam(value="name",required=true) String name,HttpServletRequest request) {
       return name;
    }
	
}

