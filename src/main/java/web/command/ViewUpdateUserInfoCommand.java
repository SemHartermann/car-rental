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


public class ViewUpdateUserInfoCommand extends Command {

	private static final long serialVersionUID = -8007538086621939654L;

	private static final Logger LOG = Logger
			.getLogger(ViewUpdateUserInfoCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewUpdateUserInfoCommand starts");
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		LOG.trace("Get attribute: userId --> "+userId);
		try {

			int userInfoId = DaoFactory.getUserInfoDAOInstance().findUserInfoByUserId(userId).getId();
			LOG.trace("Get parameter: userInfoId --> " + userInfoId);

			LOG.debug("ViewUpdateUserInfoCommand finished");
			return Path.PAGE_UPDATE_CLIENT_INFO;
		} catch (NullPointerException ex) {
			String errorMessasge = "UserInfo in DB not found";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("ViewUpdateUserInfoCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}
	}
}
