package com.web.controller.util;

/**
 * 返回内容
 * 必须添加 getter ,setter 方法
 * @author arvin
 */
public class Content {
  
	private String content;
  
    public Content(String content){
	  this.content = content;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}
