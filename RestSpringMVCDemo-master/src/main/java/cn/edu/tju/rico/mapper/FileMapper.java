package cn.edu.tju.rico.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.tju.rico.model.entity.BaseFile;

public interface FileMapper {
	@Insert("insert into file_inf(fileId, fileName, userId, uploadTime, path) values (#{fileId},#{fileName},#{userId},#{uploadTime},#{path})")
	@Options(useGeneratedKeys = true, keyProperty="fileId")
	public void saveUser(BaseFile baseFile);
	
	@Select("select path from file_inf where fileId = #{fileId}")
	public String getFilePath(@Param("fileId") int fileId);
}
