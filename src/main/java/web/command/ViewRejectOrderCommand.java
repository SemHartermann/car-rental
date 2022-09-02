package web.command;

import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewRejectOrderCommand extends Command {

	private static final long serialVersionUID = -8399663476257569009L;

	private static final Logger LOG = Logger
			.getLogger(ViewRejectOrderCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewRejectOrderCommand starts");
		LOG.debug("ViewRejectOrderCommand finished");
		return Path.PAGE_REJECT_ORDER;
	}
}
