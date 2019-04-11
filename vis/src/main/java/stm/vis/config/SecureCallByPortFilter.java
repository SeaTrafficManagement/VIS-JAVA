package stm.vis.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;

public class SecureCallByPortFilter implements Filter {

	@Value("${vis.config.privateApi.port}")
	private int privateApiPort;

	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		try {
			if (request.getServerPort() == this.privateApiPort) {
				if (httpServletRequest.getServletPath().startsWith("/privateapi/")) {
					chain.doFilter(request, response);
				}
			} else {
				if (!httpServletRequest.getServletPath().startsWith("/privateapi/")) {
					chain.doFilter(request, response);
				}
			}
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex);
		}

	}

}