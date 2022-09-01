package web.command;

import db.dao.DaoFactory;
import db.entities.UserOrderBean;
import Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * List orders by user id command.
 * <p>Uses UserOrderBean entity.
 * 
 * @author A.Yegorov
 *
 */
public class ListOrdersByUserIdCommand extends Command {

	private static final long serialVersionUID = -2643445277960241733L;

	private static final Logger LOG = Logger
			.getLogger(ListOrdersByUserIdCommand.class);

	private static Comparator<UserOrderBean> compareById = new CompareById();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ListOrdersByUserIdCommand starts");

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		LOG.trace("Get user id -->" + userId);

		List<UserOrderBean> userOrderBeanList = DaoFactory.getOrderBeanDAO().getUserOrderBeansByUserId(userId);
		LOG.trace("Found in DB: userOrderBeanListByUserId --> "
				+ userOrderBeanList);

		Collections.sort(userOrderBeanList, compareById);

		request.setAttribute("userOrderBeanListByUserId", userOrderBeanList);
		LOG.trace("Set the request attribute: userOrderBeanList --> "
				+ userOrderBeanList);

		LOG.debug("ListOrdersByUserIdCommand finished");
		return Path.PAGE_LIST_ORDERS_BY_USER_ID;
	}

	/**
	 * Serializable comparator used with TreeMap container. When the servlet
	 * container tries to serialize the session it may fail because the session
	 * can contain TreeMap object with not serializable comparator.
	 * 
	 * @author A.Yegorov
	 *
	 */
	private static class CompareById implements Comparator<UserOrderBean>,
			Serializable {
		private static final long serialVersionUID = -1573481565177573283L;

		public int compare(UserOrderBean bean1, UserOrderBean bean2) {
			return bean1.getId() - bean2.getId();
		}
	}

}
