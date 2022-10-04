package web.command;

import db.dao.DaoFactory;
import db.entities.UserInfo;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ClientCommand extends Command {

	private static final Logger LOG = Logger.getLogger(ClientCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ClientCommand starts");


		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("userId");
		LOG.trace("Get attribute: userId --> " + session.getAttribute("userId"));

		LOG.trace("Found in DB: userInfo --> " + DaoFactory.getUserInfoDAOInstance().findUserInfoByUserId(userId));

		UserInfo userInfo = DaoFactory.getUserInfoDAOInstance().findUserInfoByUserId(userId);
		LOG.trace("Found in DB: userInfo --> " + userInfo);

		List<UserInfo> userInfoList = new ArrayList<>();
		if (userInfo == null) {
			userInfoList.clear();
		} else {
			userInfoList.add(userInfo);
		}
		request.setAttribute("userProfile", userInfoList);
		LOG.trace("Set the request attribute: userProfile --> " + userInfoList);

		LOG.debug("ClientCommand finished");
		return Path.PAGE_CLIENT;
	}
}
