package cn.edu.tju.rico.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tju.rico.mapper.ActionMapper;
import cn.edu.tju.rico.model.entity.ActionInfo;
import cn.edu.tju.rico.service.ActionService;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Component("actionService")
public class ActionServiceImpl implements ActionService{
	@Resource
	private ActionMapper actionMapper;
	@Override
	public void addAction(ActionInfo actioninfo) {
		actionMapper.saveAction(actioninfo);
		
	}
	public List<Map<String, Object>> getPaneData(String type) {
		return actionMapper.getActionData(type);
	}

}
