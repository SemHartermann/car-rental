package web.command;

import db.dao.DaoFactory;
import db.entities.User;
import Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Change user status command.
 * 
 * @author A.Yegorov
 *
 */
public class ChangeUserStatusCommand extends Command {

	private static final long serialVersionUID = 3124619669223055442L;

	private static final Logger LOG = Logger
			.getLogger(ChangeUserStatusCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ChangeUserStatusCommand starts");
		HttpSession session = request.getSession();

		String userIdS = request.getParameter("id");

		if (userIdS == null || userIdS.isEmpty()) {
			String errorMessasge = "User Id cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("ChangeUserStatusCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		int userId = Integer.valueOf(userIdS);
		LOG.trace("Request parameter: userId --> " + userId);

		User user = DaoFactory.getUserDaoInstance().findUserById(userId);
		LOG.trace("Found in DB: user --> " + user);

		if (user == null) {
			String errorMessasge = "User in DB not found";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("ChangeUserStatusCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		String status = request.getParameter("status");

		boolean userStatus = true;
		if (status == null) {
			userStatus = false;
		}

		user.setStatus(userStatus);
		LOG.trace("Request parameter: userStatus --> " + user.isStatus());

		DaoFactory.getUserDaoInstance().updateUserStatus(user);
		LOG.trace("Update user status --> " + user);

		LOG.debug("ChangeUserStatusCommand finished");
		return Path.PAGE_ADMIN;
	}
}
