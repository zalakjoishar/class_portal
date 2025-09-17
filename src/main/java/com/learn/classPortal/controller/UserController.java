package com.learn.classPortal.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn.classPortal.entity.User;
import com.learn.classPortal.repositories.UserRepository;
import com.learn.classPortal.service.FileService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${user.image.path}")
	private String imagePath;
	
	@PostMapping("/{id}/upload-image")
	public ResponseEntity<String> uploadProductImage(@PathVariable int id,@RequestParam("user_image") MultipartFile image) throws IOException{
		String uploadFile=fileService.uploadFile(image, imagePath);
		User user=userRepository.findById(id).get();
		user.setImage(uploadFile);
		userRepository.save(user);
		String response=uploadFile+" image uploaded successfully";
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{id}/image")
	public void getImage(@PathVariable int id, HttpServletResponse response) throws IOException {
		User user=userRepository.findById(id).get();
		InputStream resource=fileService.getResource(imagePath, user.getImage());
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
}
