package com.web.controller.common;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 * 跳转路由
 * @author arvin
 */
@Controller
public class FileUploadController {
	
	@RequestMapping("upload")
	@ResponseBody
    public Map<String,Object> todoIndex(HttpServletRequest request,
    		@RequestParam(value="avatar_file",required=true) MultipartFile avatar_file,
    		@RequestParam(value="avatar_data",required=true) String avatar_data) {
	
		Map<String,Object> model= new HashMap<String,Object>();
		try {
			
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd-HH");     
	        /**构建图片保存的目录**/    
	        String logoPathDir = "D:/files/"+ dateformat.format(new Date());     
	        /**根据真实路径创建目录**/    
	        File logoSaveFile = new File(logoPathDir);  
	        if(!logoSaveFile.exists())     
	            logoSaveFile.mkdirs();  
	        String suffix = avatar_file.getOriginalFilename().substring  
	                (avatar_file.getOriginalFilename().lastIndexOf("."));   
	        
	        /**使用UUID生成文件名称**/    
	        String logImageName = UUID.randomUUID().toString()+ suffix;//构建文件名称     
	        /**拼成完整的文件保存路径加文件**/    
	        String fileName = logoPathDir + File.separator   + logImageName;                
            /** 图片坐标 **/
			JSONObject obj = JSONObject.parseObject(avatar_data);
			System.out.println(obj);
			
            ImageInputStream iis = ImageIO.createImageInputStream(avatar_file.getInputStream());
            // 根据图片类型获取该种类型的ImageReader
            Iterator readers = ImageIO.getImageReadersByFormatName(suffix.substring(1));
            System.out.println(readers.hasNext());
            ImageReader reader = (ImageReader) readers.next();
            reader.setInput(iis,true);
            ImageReadParam param = reader.getDefaultReadParam();
            java.awt.Rectangle rect  = new Rectangle(obj.getInteger("x"), obj.getInteger("y"), obj.getInteger("width"),  obj.getInteger("height"));
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);
            Boolean result=ImageIO.write(bi, suffix.substring(1), new File(fileName));
            model.put("result", result);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      return model;
    }
    
}

