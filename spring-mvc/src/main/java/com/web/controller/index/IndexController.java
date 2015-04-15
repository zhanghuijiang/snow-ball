package com.web.controller.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring framework mvc </br>
 * 浏览器中输入 localhost:8080/java-web/index 返回页面~页面文本内容为 " Spring Framework MVC is successed ".
 * @author arvin
 */
@Controller
public class IndexController {
	
	@RequestMapping("index")
    public String index(HttpServletRequest request) {
       return "index";
    }
	
}

