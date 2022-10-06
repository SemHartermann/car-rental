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


public class PaymentCommand extends Command {

	private static final Logger LOG = Logger.getLogger(PaymentCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("PaymentCommand starts");
		HttpSession session = request.getSession();

		int orderId = (int) session.getAttribute("orderId");
		LOG.trace("Get parameter: orderId --> " + orderId);

		Order order = DaoFactory.getOrderDaoInstance().findOrderById(orderId);
		LOG.trace("Found in BD: order --> " + order);

		LOG.trace("Get parameter: damage --> " + order.isDamage());
		boolean damaged = order.isDamage();

		int statusIdConfirm;
		if (!damaged) {
			statusIdConfirm = Status.PAID.ordinal();
		}else
			statusIdConfirm = Status.CLOSED.ordinal();
		int statusIdRefuse = Status.CLOSED.ordinal();

		String result = request.getParameter("result");
		if (result != null) {
			if (result.equalsIgnoreCase("reject")) {
				order.setStatusId(statusIdRefuse);
				LOG.trace("Request parameter: status_id --> "
						+ order.getStatusId());
			}
			if (result.equalsIgnoreCase("success")) {
				order.setStatusId(statusIdConfirm);
				LOG.trace("Request parameter: status_id --> "
						+ order.getStatusId());
			}
		} else {
			order.setStatusId(Status.CLOSED.ordinal());
			LOG.trace("Request parameter: status_id --> " + order.getStatusId());
		}

		DaoFactory.getOrderDaoInstance().updateOrderStatus(order);
		LOG.trace("Update parameter: statusId --> " + result);

		LOG.debug("PaymentCommand finished");
		return Path.PAGE_CLIENT;
	}
}