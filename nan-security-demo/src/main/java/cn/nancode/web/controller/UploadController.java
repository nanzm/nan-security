package cn.nancode.web.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.nancode.dto.FileInfo;

@RestController
@RequestMapping("/file")
public class UploadController {
	
	
	@PostMapping
	public FileInfo upload(MultipartFile file) {
		return null;
		
	}
}
