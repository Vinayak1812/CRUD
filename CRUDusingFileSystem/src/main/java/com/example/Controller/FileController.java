package com.example.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Payload.FileResponse;
import com.example.Service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile[] images){
		StringBuilder uploadedFiles = new StringBuilder();
		try {
			for(MultipartFile image : images){
				String fileName = this.fileService.uploadFile(path, image);
				uploadedFiles.append(fileName).append(", ");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(null, "Image is not uploaded due to server error!!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		String uploadedFileNames = uploadedFiles.toString();
		if(uploadedFileNames.endsWith(", ")){
			uploadedFileNames = uploadedFileNames.substring(0,uploadedFileNames.length()-2);
		}
		
		return new ResponseEntity<>(new FileResponse(uploadedFileNames, "Image ios successfully uploaded !!"),HttpStatus.OK);
	}
 }
