package cn.edu.tju.rico.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.tju.rico.model.entity.ActionInfo;
import cn.edu.tju.rico.model.entity.User;

public interface ActionMapper {
	@Insert("insert into Action_info(actionName, provinceCode, cityCode, areaCode,address,content,actionTime,orderCount,remain,phoneNo,"
			+ "price,type,picId,remark,status) values (#{actionName},#{provinceCode},#{cityCode},#{areaCode},#{address},"
			+ "#{content},#{actionTime},#{orderCount},#{remain},#{phoneNo},#{price},#{type},#{picId},#{remark},#{status})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	public void saveAction(ActionInfo actionInfo);
	
	
	@Select("select * from action_info t where t.type = #{type}")
	public List<Map<String,Object>> getActionData(String type);


}
