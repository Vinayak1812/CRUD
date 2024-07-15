package com.example.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadFile(String path, MultipartFile file) throws IOException {
		
		// File name
		String name = file.getOriginalFilename(); 
		
		// Fullpath
		String filePath = path+File.separator+name;
		
		// create folder if not already exist
		File oldFile = new File(path);
		if(!oldFile.exists()) {
			oldFile.mkdirs();
		}
		
		// file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return name;
	}
}
