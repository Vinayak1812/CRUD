package com.example.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public String uploadFile(String path, MultipartFile file)throws IOException;
}
