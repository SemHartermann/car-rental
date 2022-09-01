package web.command;

import db.dao.DaoFactory;
import Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * View add user info command.
 * 
 * @author A.Yegorov
 *
 */
public class ViewAddUserInfoCommand extends Command {

	private static final long serialVersionUID = 8634451502222349682L;

	private static final Logger LOG = Logger
			.getLogger(ViewAddManagerCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewAddUserInfoCommand starts");
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
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
