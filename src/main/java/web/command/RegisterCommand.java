package web.command;

import db.entities.UserInfo;
import db.entities.enums.Role;
import db.dao.DaoFactory;
import db.entities.User;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class RegisterCommand extends Command {

	private static final Logger LOG = Logger.getLogger(RegisterCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("RegisterCommand starts");
		HttpSession session = request.getSession();
		String forward = Path.PAGE_REGISTER;

		User user = new User();
		user.setRoleId(Role.CLIENT.ordinal());

		String email = request.getParameter("email");
		user.setEmail(email);
		LOG.trace("Request parameter: email --> " + user.getEmail());
		String password = request.getParameter("password");
		user.setPassword(password);
		LOG.trace("Request parameter: password --> " + user.getPassword());

		if (email.isEmpty() || password.isEmpty()) {
			String errorMessasge = "Email/password cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			forward = Path.PAGE_ERROR_PAGE;
			LOG.debug("RegisterCommand finished");
			return forward;
		}

		List<User> list = DaoFactory.getUserDaoInstance().findUsers();
		for (User user2 : list) {
			if (user2.getEmail().equals(email)) {
				String errorMessasge = "Login already exist";
				session.setAttribute("errorMessage", errorMessasge);
				LOG.error("Set the session attribute: errorMessage --> "
						+ errorMessasge);
				forward = Path.PAGE_ERROR_PAGE;
				LOG.debug("RegisterCommand finished");
				return forward;
			}
		}



		LOG.trace("Create new user --> " + user);
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(DaoFactory.getUserDaoInstance().addUser(user).getId());
		DaoFactory.getUserInfoDAOInstance().addUserInfo(userInfo);
		LOG.trace("Create new userInfo --> " + userInfo);

		session.setAttribute("login", user.getEmail());

		forward = Path.PAGE_LOGIN;
		LOG.debug("RegisterCommand finished");
		return forward;
	}
}
