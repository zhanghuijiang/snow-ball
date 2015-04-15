package com.web.controller.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.util.ApplicationContextUtil;
import com.web.controller.util.Code;
import com.web.controller.util.Content;
import com.web.controller.util.Status;
import com.web.service.UserService;

/**
 * It’s a very common use case to have Controllers implement a REST API, 
 * thus serving only JSON, XML or custom MediaType content. 
 * For convenience, instead of annotating all your @RequestMapping methods with @ResponseBody, 
 * you can annotate your Controller Class with @RestController.
 * @author arvin
 */
@RestController
public class LoginController {
	
	/**
	 * 查询用户数量
	 * @param request
	 * @return
	 */
	@RequestMapping("userCount")
    public Content userCount(HttpServletRequest request) {
	   UserService service=(UserService) ApplicationContextUtil.getBean(request, "userService", UserService.class);
	   int count = service.getSysUserCount(); 
	   return new Content(String.valueOf(count));   
    }

	/**
	 * 用户登录：查询用户是否存在
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
    public Status login(HttpServletRequest request,
    		@RequestParam(value="email",required=true) String email,
    		@RequestParam(value="password",required=true) String password) {
	   UserService service=(UserService) ApplicationContextUtil.getBean(request, "userService", UserService.class);
	   List<Map<String, Object>> list = service.getSysUser(email,password); 
	   if(list==null ||list.size() == 0){
	      return new Status(Integer.valueOf(Code.FAILURE.toString()),"登录失败");   
	   }else{
	      return new Status(Integer.valueOf(Code.SUCCESS.toString()),"登录成功") ;  
	   }
    }
}
