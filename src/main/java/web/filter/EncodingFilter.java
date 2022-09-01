package web.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Encoding filter.
 * 
 * @author A.Yegorov
 * 
 */
public class EncodingFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(EncodingFilter.class);

	private String encoding;

	public void destroy() {
		LOG.debug("Filter destruction starts");
		LOG.debug("Filter destruction finished");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		LOG.debug("Filter starts");

		String requestEncoding = request.getCharacterEncoding();
		if (requestEncoding == null) {
			LOG.trace("Request encoding = null, set encoding --> " + encoding);
			request.setCharacterEncoding(encoding);
		}

		LOG.debug("Filter finished");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		LOG.debug("Filter initialization starts");
		encoding = fConfig.getInitParameter("encoding");
		LOG.trace("Encoding from web.xml --> " + encoding);
		LOG.debug("Filter initialization finished");
	}

}