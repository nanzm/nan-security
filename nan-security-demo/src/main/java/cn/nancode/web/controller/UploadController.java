package cn.nancode.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.nancode.dto.FileInfo;

@RestController
@RequestMapping("/file")
public class UploadController {

	private String folder = "/Users/nan/Desktop/workspace/nan-security-demo/src/main/resources/upload";

	@PostMapping
	public FileInfo upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		File localFile = new File(folder, new Date().getTime() + ".txt");

		// file.getInputStream() 可以写入到任意
		file.transferTo(localFile);

		return new FileInfo(localFile.getAbsolutePath());

	}

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		
		//jdk 新语法  自动关闭流
		try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
				OutputStream outputStream = response.getOutputStream();) {
			
				response.setContentType("application/x-download");
				response.addHeader("content-Disposition", "attachment;filename=test.txt");
				
				IOUtils.copy(inputStream, outputStream);
				outputStream.flush();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
