import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class MyFilter extends HttpFilter implements Filter {
	
	private FilterConfig filterconfig; 
	
	public MyFilter() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	// 사용자의 요청 & 응답에서 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("서블릿 가기 전");
		
		///////////////////////////////////////////
		// 서블릿으로 보내는 코드 
		// 더 보낼 필터 없으면 ... 
		chain.doFilter(request, response);
		///////////////////////////////////////////
		System.out.println("서블릿 다녀온 후 ");
	
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
}
