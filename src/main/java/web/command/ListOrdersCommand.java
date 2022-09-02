package web.command;

import db.dao.DaoFactory;
import db.entities.UserOrderBean;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListOrdersCommand extends Command {

	private static final long serialVersionUID = -2935388551915607099L;

	private static final Logger LOG = Logger.getLogger(ListOrdersCommand.class);

	private static Comparator<UserOrderBean> compareById = new CompareById();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ListOrdersCommand starts");

		List<UserOrderBean> userOrderBeanList = DaoFactory.getOrderBeanDAO().getUserOrderBeans();
		LOG.trace("Found in DB: userOrderBeanList --> " + userOrderBeanList);

		Collections.sort(userOrderBeanList, compareById);

		// put user order beans list to request
		request.setAttribute("userOrderBeanList", userOrderBeanList);
		LOG.trace("Set the request attribute: userOrderBeanList --> "
				+ userOrderBeanList);

		LOG.debug("ListOrdersCommand finished");
		return Path.PAGE_LIST_ORDERS;
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
