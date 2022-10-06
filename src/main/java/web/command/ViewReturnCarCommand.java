package web.command;

import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ViewReturnCarCommand extends Command {

	private static final Logger LOG = Logger
			.getLogger(ViewReturnCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewReturnCarCommand starts");
		HttpSession session = request.getSession();

		int orderId = Integer.parseInt(request.getParameter("orderId"));
		LOG.trace("Request parameter: orderId --> " + orderId);

		session.setAttribute("orderId", orderId);
		LOG.debug("ViewReturnCarCommand finished");
		return Path.PAGE_RETURN_ORDER;
	}
}
