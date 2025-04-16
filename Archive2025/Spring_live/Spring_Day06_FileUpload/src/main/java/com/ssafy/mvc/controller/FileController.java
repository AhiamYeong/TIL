package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	//스프링에서는 파일이나 클래스 등등 리소스를 로드할떄 ResourceLoader 인터페이스를 활용한다.
	//의존성 주입(생성자/설정자/필드)
//	@Autowired
	private ResourceLoader resourceLoader;

//	@Autowired	 //생성자가 한개 뿐이라 알잘로 들어감
	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		return "singleFileForm";
	}
	
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		//파일이 있는지 검사!
		if(file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename(); //업로드한 파일의 기본 이름
			//임시 메모리에 파일이 있다는 것!
			//실제로 서버에 저장을 해야해!
			
			//static/img 폴더를 가지고 와야해!
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			//넘겨받은 파일을 저장할꺼야
			file.transferTo(new File(resource.getFile(), fileName));
			
			model.addAttribute("fileName", fileName);
		}
		
		return "result";
	}
	
	@GetMapping("/multiFileForm")
	public String multiFileForm() {
		return "multiFileForm";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("files") MultipartFile[] files, Model model) throws IllegalStateException, IOException {
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		
		
		return "result";
	}
	
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
