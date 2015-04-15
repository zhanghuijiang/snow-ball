package com.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.util.ApplicationContextUtil;
import com.web.service.UserService;

/**
 * spring framework mvc </br>
 * 连接数据库，显示数据库信息
 * @author arvin
 */
@Controller
public class UserController {
	
	@RequestMapping("getUserCount")
    public ModelAndView getUserCount(HttpServletRequest request) {
	   UserService service=(UserService) ApplicationContextUtil.getBean(request, "userService", UserService.class);
	   int i = service.getUserCount();
	   Map<String,Object> m = new HashMap<String,Object>();
	   m.put("userCount", i);
       return new ModelAndView("/print",m);
    }
	
	
	@RequestMapping("addUser")
    public ModelAndView addUser(HttpServletRequest request,
    		@RequestParam(required=false, defaultValue="default") String name,
    		@RequestParam(required=false, defaultValue="0") int age) {
	   UserService service=(UserService) ApplicationContextUtil.getBean(request, "userService", UserService.class);
	   Map<String,Object> m = new HashMap<String,Object>();
	   int incount = service.addUser(name,age);
	   int i = service.getUserCount();
	   m.put("userCount", i);
	   m.put("incount", incount);
       return new ModelAndView("/addUser",m);
    }
	
	@RequestMapping("createCollection")
    public ModelAndView getMongo(HttpServletRequest request,
    		@RequestParam(required=false, defaultValue="default") String name) {
	   UserService service=(UserService) ApplicationContextUtil.getBean(request, "userService", UserService.class);
	   boolean i = service.createCollection(name);
	   Map<String,Object> m = new HashMap<String,Object>();
	   m.put("exist", i);
       return new ModelAndView("/mongo",m);
    }
	
}

