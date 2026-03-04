package com.capgemini.cachepractice.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.cachepractice.entity.FileData;
import com.capgemini.cachepractice.repo.FileRepository;

@RestController
@RequestMapping("/files")
public class FileController {

	
	private FileRepository repository;
	
	public FileController(FileRepository repository) {
		super();
		this.repository = repository;
	}


	@PostMapping("/upload")
	public FileData upload(@RequestParam("file") MultipartFile file) throws IOException {
		
		FileData data = new FileData();
		data.setFilename(file.getOriginalFilename());
		data.setFiletype(file.getContentType());
		data.setData(file.getBytes());
		
		FileData saved = repository.save(data);
		
		return saved;
	}
	@GetMapping("/download/{file}")
	public ResponseEntity<byte[]> download(@PathVariable int id) {
		FileData data = repository
				.findById(id)
				.orElseThrow(()->new RuntimeException("FileNotFound"));
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,data.getFilename()).
				header(HttpHeaders.CONTENT_TYPE,data.getFiletype()).
				body(data.getData());
	}
}
