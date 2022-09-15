package web.command;

import db.dao.DaoFactory;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ViewAddUserInfoCommand extends Command {


	private static final Logger LOG = Logger
			.getLogger( ViewAddUserInfoCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewAddUserInfoCommand starts");
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		LOG.debug("Get parametr: carId --> "+ request.getParameter("carId"));
		session.setAttribute("carId",request.getParameter("carId"));
		try {
			int userInfoId = DaoFactory.getUserInfoDAOInstance().findUserInfoByUserId(userId).getId();
			LOG.trace("Get parametr: userInfoId --> " + userInfoId);
			LOG.debug("ViewAddUserInfoCommand finished");
			return Path.PAGE_ADD_ORDER;
		} catch (NullPointerException ex) {
			LOG.trace("UserInfo in DB not found");
			LOG.debug("ViewAddUserInfoCommand finished");
			return Path.PAGE_ADD_CLIENT_INFO;
		}
	}
}
