package cn.edu.tju.rico.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.tju.rico.annotation.IgnoreSecurity;
import cn.edu.tju.rico.model.entity.ActionInfo;
import cn.edu.tju.rico.service.ActionService;

@RestController
//@RequestMapping(value = "/actions")
public class ActionController {
	@Resource(name="actionService")
	private ActionService actionService;
	
	
	@RequestMapping(value = "/action", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@IgnoreSecurity
	public void addAction(@RequestBody @Valid ActionInfo actioninfo) {
		actionService.addAction(actioninfo);
	}
}
