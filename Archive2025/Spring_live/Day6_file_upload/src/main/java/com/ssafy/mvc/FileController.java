package com.ssafy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		return "singleFileForm";
	}
	
	@PostMapping("/singleFileUpload")
	public String postMethodName(@RequestParam ("file") MultipartFile file) {

		if (file != null )
		System.out.println(file.getSize());
		return "result";
	}
	
}
