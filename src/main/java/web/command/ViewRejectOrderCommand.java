package web.command;

import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ViewRejectOrderCommand extends Command {


	private static final Logger LOG = Logger
			.getLogger(ViewRejectOrderCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewRejectOrderCommand starts");

		HttpSession session = request.getSession();

		int orderId = Integer.parseInt(request.getParameter("orderId"));
		LOG.trace("Request parameter: orderId --> " + orderId);

		session.setAttribute("orderId", orderId);

		LOG.debug("ViewRejectOrderCommand finished");
		return Path.PAGE_REJECT_ORDER;
	}
}
