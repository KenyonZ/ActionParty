package cn.edu.tju.rico.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.tju.rico.annotation.IgnoreSecurity;
import cn.edu.tju.rico.model.entity.BaseFile;
import cn.edu.tju.rico.service.UploadService;
import cn.edu.tju.rico.utils.UploadUtil;

@RestController
public class UploadController {
	@Resource(name = "uploadService")
	private UploadService uploadService;
	
	@RequestMapping(value = "/upload")
	@IgnoreSecurity
	public Map<String, Object> uploadFiles (HttpServletResponse response,HttpServletRequest request) throws IOException {  
        request.setCharacterEncoding("utf-8");
        String contentType = request.getContentType();
        response.setContentType("text/html;charset=utf-8");  
        String path = request.getSession().getServletContext().getRealPath(  
                "/BackstageShoppingWebsite/images/addCircleimage");//保存的服务器地址  
        Map<String, Object> map = UploadUtil  
                .upload(request, 1024 * 1024 * 10, path);  
//        String file= map.get("file"); // 名称  
//        String image = map.get("type"); // 图像  
//        String newFile = map.get("newFile");// 地址  
          BaseFile bf = new BaseFile();
          
          bf.setFileName(map.get("fileName").toString());
          bf.setPath(map.get("newFile").toString());
          bf.setUploadTime(new Date());
          bf.setFileSize(new Long((long)map.get("fileSize")));
          uploadService.addFile(bf);
        return map;  
    }  
	

}
