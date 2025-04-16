package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView {
	// 스프링에서는 파일이나 클래스 등등 리소스를 로드할떄 ResourceLoader 인터페이스를 활용한다.
	private ResourceLoader resourceLoader;

//	@Autowired	 //생성자가 한개 뿐이라 알잘로 들어감
	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// model -> 파일이름 저장해서 해당 뷰로 넘겼다.
		String fileName = (String) model.get("fileName");
		// static/img 폴더 안에 있어!
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(), fileName); //이미지 구나! -> X
		
		//////////////////////////////////////////////////////////////////
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1"); //한글 꺠짐 방지
		response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//////////////////////////////////////////////////////////////////
		//파일을 다운로드받게 해주자
		try(FileInputStream fis = new FileInputStream(file);
				OutputStream os = response.getOutputStream();){
			FileCopyUtils.copy(fis, os);
		}
	}
}
