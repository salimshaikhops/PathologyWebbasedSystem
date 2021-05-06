package com.restapi.test;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import helper.Fileupload;

@RestController
public class FileUploadController {

	@PostMapping("/fileUpload")
	public ResponseEntity<String> fileuploading(@RequestParam("file") MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("reque");
		}
	 if(file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpg format required");

			
		}
		//file uploading code
	 
	 	boolean status=Fileupload.uplodaFile(file);
	 	if(status)
	 	{
	 		return ResponseEntity.ok("succefully upload");
	 	}
	 	else
	 	{
	 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong try again");
	
	 	}	
	}


}
