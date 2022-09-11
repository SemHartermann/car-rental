package web.command;

import db.dao.DaoFactory;
import db.entities.UserOrderBean;
import web.Path;
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


public class ListOrdersByUserIdCommand extends Command {


	private static final Logger LOG = Logger
			.getLogger(ListOrdersByUserIdCommand.class);

	private static final Comparator<UserOrderBean> compareById = new CompareById();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ListOrdersByUserIdCommand starts");

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(String.valueOf(session.getAttribute("userId")));
		LOG.trace("Get user id -->" + userId);

		List<UserOrderBean> userOrderBeanList = DaoFactory.getOrderBeanDAO().getUserOrderBeansByUserId(userId);
		LOG.trace("Found in DB: userOrderBeanListByUserId --> "
				+ userOrderBeanList);

		userOrderBeanList.sort(compareById);

		request.setAttribute("userOrderBeanListByUserId", userOrderBeanList);
		LOG.trace("Set the request attribute: userOrderBeanList --> "
				+ userOrderBeanList);

		LOG.debug("ListOrdersByUserIdCommand finished");
		return Path.PAGE_LIST_ORDERS_BY_USER_ID;
	}

	private static class CompareById implements Comparator<UserOrderBean>,
			Serializable {

		public int compare(UserOrderBean bean1, UserOrderBean bean2) {
			return bean1.getId() - bean2.getId();
		}
	}

}
