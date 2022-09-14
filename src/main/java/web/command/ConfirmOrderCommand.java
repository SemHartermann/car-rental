package web.command;

import db.entities.enums.Status;
import db.dao.DaoFactory;
import db.entities.Order;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ConfirmOrderCommand extends Command {

	private static final Logger LOG = Logger
			.getLogger(ConfirmOrderCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ConfirmOrderCommand starts");

		HttpSession session = request.getSession();

		String orderIdS = request.getParameter("id");
		if (orderIdS == null || orderIdS.isEmpty()) {
			String errorMessasge = "Order Id cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("ConfirmOrderCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		int orderId = Integer.valueOf(orderIdS);
		LOG.trace("Request parameter: orderId --> " + orderId);

		Order order = DaoFactory.getOrderDaoInstance().findOrderById(orderId);
		LOG.trace("Found in DB: order --> " + order);

		if (order.getId() == 0) {
			String errorMessasge = "Order in DB not found";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("ConfirmOrderCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		int statusConfirm = Status.CONFIRMED.ordinal();
		order.setStatusId(statusConfirm);

		DaoFactory.getOrderDaoInstance().updateOrderStatusRej(order);
		LOG.trace("Update order status --> " + order);

		LOG.debug("ConfirmOrderCommand finished");
		return Path.PAGE_MANAGER;
	}
}
