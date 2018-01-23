package cn.edu.tju.rico.service;

import java.util.List;
import java.util.Map;

import cn.edu.tju.rico.model.entity.ActionInfo;

public interface ActionService {
	public void addAction(ActionInfo actioninfo);
	
	public List<Map<String,Object>> getPaneData(String type);
}
