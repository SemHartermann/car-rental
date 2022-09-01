package web.command;

import db.entities.enums.Status;
import db.dao.DaoFactory;
import db.entities.Order;
import Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Return car command.
 * 
 * @author A.Yegorov
 *
 */
public class ReturnCarCommand extends Command {

	private static final long serialVersionUID = -5830610361996655024L;

	private static final Logger LOG = Logger.getLogger(ReturnCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ReturnCarCommand starts");

		HttpSession session = request.getSession();

		String orderIdS = request.getParameter("id");

		if (orderIdS == null || orderIdS.isEmpty()) {
			String errorMessasge = "Order Id cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("ReturnCarCommand finished");
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
			LOG.debug("ReturnCarCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		int statusReject = Status.CLOSED.ordinal();
		order.setStatusId(statusReject);

		/*String status = request.getParameter("damage");
		boolean damage = true;
		if (status == null) {
			damage = false;
		}
		order.setDamage(damage);
		LOG.trace("Request parameter: damage --> " + order.isDamage());

		if (order.isDamage()) {
			String price = request.getParameter("priceForRepairs");
			if (price.isEmpty()) {
				String errorMessasge = "Price cannot be empty";
				session.setAttribute("errorMessage", errorMessasge);
				LOG.error("Set the session attribute: errorMessage --> "
						+ errorMessasge);
				LOG.debug("ReturnCarCommand finished");
				return Path.PAGE_ERROR_PAGE;
			} else {
				int priceForRepairs = Integer.valueOf(price);
				order.setPriceForRepairs(priceForRepairs);
				LOG.trace("Request parameter: priceForRepairs --> "
						+ order.getPriceForRepairs());
			}
		}*/

		DaoFactory.getOrderDaoInstance().updateOrderReturn(order);
		LOG.trace("Update order status --> " + order);

		LOG.debug("ReturnCarCommand finished");
		return Path.PAGE_MANAGER;
	}

}
