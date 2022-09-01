package web.command;

import db.dao.DaoFactory;
import db.entities.UserInfoBean;
import Path;
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

/**
 * List clients info command.
 * <p>Uses UserInfoBean entity.
 * 
 * @author A.Yegorov
 *
 */
public class ListClientInfoCommand extends Command {

	private static final long serialVersionUID = 2355012921147521257L;

	private static final Logger LOG = Logger
			.getLogger(ListClientInfoCommand.class);

	private static Comparator<UserInfoBean> compareById = new CompareById();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ListClientInfoCommand starts");

		List<UserInfoBean> userInfoBeanList = DaoFactory.getUserInfoDaoBeanInstance().getUserInfoBeans();
		LOG.trace("Found in DB: userInfoBeanList --> " + userInfoBeanList);

		Collections.sort(userInfoBeanList, compareById);

		// put user order beans list to request
		request.setAttribute("userInfoBeanList", userInfoBeanList);
		LOG.trace("Set the request attribute: userInfoBeanList --> "
				+ userInfoBeanList);

		LOG.debug("ListClientInfoCommand finished");
		return Path.PAGE_LIST_CLIENT_INFO;
	}

	/**
	 * Serializable comparator used with TreeMap container. When the servlet
	 * container tries to serialize the session it may fail because the session
	 * can contain TreeMap object with not serializable comparator.
	 * 
	 * @author A.Yegorov
	 *
	 */
	private static class CompareById implements Comparator<UserInfoBean>,
			Serializable {
		private static final long serialVersionUID = -1573481565177573283L;

		public int compare(UserInfoBean bean1, UserInfoBean bean2) {
			return bean1.getId() - bean2.getId();
		}
	}
}
