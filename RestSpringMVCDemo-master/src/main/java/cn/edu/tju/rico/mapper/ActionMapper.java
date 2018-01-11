package cn.edu.tju.rico.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import cn.edu.tju.rico.model.entity.ActionInfo;

public interface ActionMapper {
	@Insert("insert into Action_info(actionName, provinceCode, cityCode, areaCode,address,content,actionTime,phoneNo,"
			+ "type,picId,remark,status) values (#{actionName},#{provinceCode},#{cityCode},#{areaCode},#{address},"
			+ "#{content},#{actionTime},#{phoneNo},#{type},#{picId},#{remark},#{status})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	public void saveAction(ActionInfo actionInfo);

}
