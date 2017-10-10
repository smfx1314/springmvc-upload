package com.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value="/uploadPage.do",method=RequestMethod.GET)
	public String uploadPage(){
		return "uploadPage";
	}
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	public String upload(@RequestParam("upload") MultipartFile file){
		//����1
		/*try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/sshupload",System.currentTimeMillis()+file.getOriginalFilename()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
		//����2
		 String path="/fileUplaod"+new Date().getTime()+file.getOriginalFilename();
         
	        File newFile=new File(path);
	        //ͨ��CommonsMultipartFile�ķ���ֱ��д�ļ���ע�����ʱ��	    
					try {
						file.transferTo(newFile);
					} catch (IllegalStateException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}		
					
		return "success";
	}
}
