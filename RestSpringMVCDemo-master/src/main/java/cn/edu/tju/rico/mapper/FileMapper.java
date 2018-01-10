package cn.edu.tju.rico.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import cn.edu.tju.rico.model.entity.BaseFile;

public interface FileMapper {
	@Insert("insert into file_inf(fileId, fileName, userId, uploadTime, path) values (#{fileId},#{fileName},#{userId},#{uploadTime},#{path})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	public void saveUser(BaseFile baseFile);
}
