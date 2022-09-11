package web.command;

import db.entities.enums.Role;
import db.dao.DaoFactory;
import db.entities.User;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;
import util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class LoginCommand extends Command {

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	private SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DATE_FORMAT);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("LoginCommand starts");
		String forward = Path.PAGE_ERROR_PAGE;
		HttpSession session = request.getSession();

		User user = null;

		String login = request.getParameter("email");
		LOG.trace("Request parameter: email --> " + login);
		String password = request.getParameter("password");
		LOG.trace("Request parameter: password --> " + password);

		if (login == null || password == null || login.isEmpty()
				|| password.isEmpty()) {
			String errorMessasge = "Login/password cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			forward = Path.PAGE_ERROR_PAGE;
			LOG.debug("LoginCommand finished");
			return forward;
		}

		user = DaoFactory.getUserDaoInstance().findUserByLogin(login);
		LOG.trace("Found in DB: user --> " + user);

		if (user == null || !password.equals(user.getPassword())) {
			String errorMessasge = "Cannot find user with such login/password";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			forward = Path.PAGE_ERROR_PAGE;
			LOG.debug("LoginCommand finished");
			return forward;
		}

		if (user.isStatus()) {
			String errorMessasge = "You was blocked!";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			forward = Path.PAGE_ERROR_PAGE;
			LOG.debug("LoginCommand finished");
			return forward;
		}

		// set user config to session
		Role userRole = Role.getRole(user);
		LOG.trace("userRole --> " + userRole);

		if (userRole == Role.ADMIN) {
			forward = Path.PAGE_ADMIN;
			LOG.trace("forward --> " + forward);
		}

		if (userRole == Role.MANAGER) {
			forward = Path.PAGE_MANAGER;
			LOG.trace("forward --> " + forward);
		}

		if (userRole == Role.CLIENT) {
			forward = Path.PAGE_CLIENT;
			LOG.trace("forward --> " + forward);
		}

		Date setCurrentDate = DateUtil.getCurrentDate();
		String setCurrentDateStr = sdf.format(setCurrentDate);
		Date setYearsAfterDate = DateUtil.afterOneYearDate(setCurrentDate);
		String setYearsAfterDateStr = sdf.format(setYearsAfterDate);
		session.setAttribute("currentDate", setCurrentDateStr);
		session.setAttribute("yearsAfterDate", setYearsAfterDateStr);

		session.setAttribute("user", user);
		LOG.trace("Set the session attribute: user --> " + user);

		session.setAttribute("userRole", userRole);
		LOG.trace("Set the session attribute: userRole --> " + userRole);

		session.setAttribute("userId", user.getId());
		LOG.trace("Set the session attribute: userId --> " + user.getId());

		LOG.info(user + " logged as " + userRole.toString().toLowerCase());

		LOG.debug("LoginCommand finished");
		return forward;
	}
}
