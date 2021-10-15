package com.mvc2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static void makeDir(String path) {
		File folder = new File(path);
		if(!folder.exists()) //폴더 존재여부 확인 (존재: true)  
		{
			try {
				folder.mkdirs(); //폴더 생성 : mkdirs - 모든 경로 폴더생성 / mkdir - 마지막 경로 폴더만 생성 
		    }
			catch(Exception e) {
			    e.getStackTrace();
			}    
		}
	}
	
	public static Map<String, Object> upload(String path, MultipartFile file) {
		long fileSize = file.getSize(); //파일길이
		if(fileSize < 1) {
			return null;
		}
		
		String fileType = FilenameUtils.getExtension(file.getOriginalFilename()); //확장자
		String fileName = file.getOriginalFilename(); //AS-IS 파일명
		fileName = fileName.substring(0, fileName.lastIndexOf("."+fileType));
		String fileSaveName = UUID.randomUUID().toString(); //TO-BE 파일명
		
		File target = new File(path, fileSaveName);
        try {
        	FileCopyUtils.copy(file.getBytes(), target);
		} 
        catch (IOException e) {
			e.printStackTrace();
		}
        
        Map<String, Object> temp = new HashMap<String,Object>();
		temp.put("fileName", fileName);
		temp.put("fileSaveName", fileSaveName);
		temp.put("fileType", fileType);
		temp.put("fileSize", fileSize);
		temp.put("filePath", path);
		return temp;
	}
	
	public static boolean delete(String path, String fileName) {
		boolean result = true;
		File target = new File(path, fileName);
		if(target.exists()) {
			result = target.delete();
		}
		return result;
	}
	
	public static void multiDelete(List<Map<String, Object>> fileList) {
		for(Map<String, Object> file : fileList) {
			String fileSaveName = StringUtil.fixNull(file.get("fileSaveName"));
			String filePath = StringUtil.fixNull(file.get("filePath"));
			delete(filePath, fileSaveName);
		}
	}
	
	public static void download(HttpServletResponse response, Map<String,Object> param) {
		try 
		{
			String filePath = StringUtil.fixNull(param.get("filePath"));
			String fileSaveName = StringUtil.fixNull(param.get("fileSaveName"));
			String fileName = StringUtil.fixNull(param.get("fileName"));
			String fileType = StringUtil.fixNull(param.get("fileType"));
			String fileSize = StringUtil.fixNull(param.get("fileSize"));
			
			filePath = filePath + "/" + fileSaveName;
			fileName = URLEncoder.encode(fileName+"."+fileType ,"UTF-8"); 
			int size = Integer.parseInt(fileSize);
			
			response.setContentType("application/download;charset=utf-8");
			response.setContentLength(size);
			response.setHeader("Content-Disposition", "attachment;fileName=\""+fileName+"\";");
		
			OutputStream out = response.getOutputStream();
			FileInputStream fis = new FileInputStream(new File(filePath));
			FileCopyUtils.copy(fis, out);
			fis.close();
			out.close(); 
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
