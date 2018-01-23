package cn.edu.tju.rico.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.tju.rico.annotation.IgnoreSecurity;
import cn.edu.tju.rico.model.entity.ActionInfo;
import cn.edu.tju.rico.service.ActionService;
import cn.edu.tju.rico.service.UploadService;

@RestController
@RequestMapping(value = "/actions")
public class ActionController {
	@Resource(name="actionService")
	private ActionService actionService;
	
	@Resource(name = "uploadService")
	private UploadService uploadService;
	
	
	@RequestMapping(value = "/action", method = RequestMethod.POST)
	@IgnoreSecurity
	public ActionInfo addAction(@RequestBody @Valid ActionInfo actioninfo) {
		actioninfo.setRemain(actioninfo.getOrderCount());
		actioninfo.setStatus("1");
		actionService.addAction(actioninfo);
		return actioninfo;
	}
	
	@RequestMapping(value = "/getPaneData/{type}", method = RequestMethod.GET,produces = "application/json")
	@IgnoreSecurity
	public List<Map<String,Object>> getPaneData(@PathVariable String type) {
		List<Map<String,Object>> ActList = actionService.getPaneData(type);
		for(Map<String,Object> actInfo:ActList){
			if(actInfo.get("picId")!=null && !"".equals(actInfo.get("picId"))){
				String picId = actInfo.get("picId").toString().split(",")[0];
				String photoUrl = uploadService.getFilePath(Integer.parseInt(picId));
				actInfo.put("photoUrl", photoUrl);
			}
		}
		return ActList;
	}
}
