package cn.edu.tju.rico.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tju.rico.mapper.FileMapper;
import cn.edu.tju.rico.model.entity.BaseFile;
import cn.edu.tju.rico.service.UploadService;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Component("uploadService")
public class UploadServiceImpl implements UploadService{
	@Resource
	private FileMapper fileMapper;
	
	@Override
	public void addFile(BaseFile baseFile) {
		fileMapper.saveUser(baseFile);
	}

	@Override
	public String getFilePath(int fileId) {
		return fileMapper.getFilePath(fileId);
	}

}
