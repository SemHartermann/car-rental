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


public class RejectOrderCommand extends Command {

	private static final long serialVersionUID = 4055593803407561664L;

	private static final Logger LOG = Logger
			.getLogger(RejectOrderCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("RejectOrderCommand starts");

		HttpSession session = request.getSession();

		String orderIdS = request.getParameter("id");

		if (orderIdS == null || orderIdS.isEmpty()) {
			String errorMessasge = "Order Id cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("RejectOrderCommand finished");
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
			LOG.debug("RejectOrderCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		int statusReject = Status.REJECTED.ordinal();
		order.setStatusId(statusReject);

		String rejReason = request.getParameter("rejectionReason");
		LOG.trace("Request parameter: rejReason --> " + rejReason);

		if (rejReason == null || rejReason.isEmpty()) {
			String errorMessasge = "Rejection reason cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("RejectOrderCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		order.setRejectionReason(rejReason);

		DaoFactory.getOrderDaoInstance().updateOrderStatusRej(order);
		LOG.trace("Update order status --> " + order);

		LOG.debug("RejectOrderCommand finished");
		return Path.PAGE_MANAGER;
	}
}
