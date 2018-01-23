package cn.edu.tju.rico.service;

import cn.edu.tju.rico.model.entity.BaseFile;

public interface UploadService {
	
	public void addFile(BaseFile baseFile);
	
	public String getFilePath(int fileId);

}
