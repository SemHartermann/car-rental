package web.command;

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

public class AddManagerCommand extends Command {


	private static final Logger LOG = Logger.getLogger(AddManagerCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("AddManagerCommand starts");

		HttpSession session = request.getSession();
		User user = new User();

		int idRole = Role.MANAGER.ordinal();
		user.setRoleId(idRole);

		String login = String.valueOf(request.getParameter("login"));
		user.setEmail(login);
		LOG.trace("Request parameter: loging --> " + user.getEmail());
		String password = String.valueOf(request.getParameter("password"));
		user.setPassword(password);
		LOG.trace("Request parameter: password --> " + user.getPassword());

		if (login == null || password == null || login.isEmpty()
				|| password.isEmpty()) {
			String errorMessasge = "Login/password cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("AddManagerCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		DaoFactory.getUserDaoInstance().addUser(user);
		LOG.trace("Create new manager --> " + user);

		LOG.debug("AddManagerCommand finished");
		return Path.PAGE_ADMIN;
	}
}
