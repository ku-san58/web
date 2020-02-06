package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter("/*")
public class ExampleFilter implements Filter {
	
	private static final String DEFAULT_ENCODING = "UTF-8";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding(DEFAULT_ENCODING);
		response.setContentType("text/html; charset=" + DEFAULT_ENCODING);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
