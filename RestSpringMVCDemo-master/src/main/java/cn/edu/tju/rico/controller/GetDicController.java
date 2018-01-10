package cn.edu.tju.rico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.tju.rico.annotation.IgnoreSecurity;
import cn.edu.tju.rico.utils.XmlUtil;

@RestController
public class GetDicController {
	
	@RequestMapping(value = "/getDic")
	@IgnoreSecurity
	public List getAllDic(@PathVariable("DicName")String DicName) {
		String path = this.getClass().getResource("").getPath();
		path = path.substring(0, path.length() - 13);
		String filePath = path + "dic/" + DicName + ".dic";
		return XmlUtil.readTxtFile(filePath);

    }  
}
