package web.command;

import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewAddManagerCommand extends Command {

	private static final long serialVersionUID = 8634451502222349682L;

	private static final Logger LOG = Logger
			.getLogger(ViewAddManagerCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewAddManagerCommand starts");
		LOG.debug("ViewAddManagerCommand finished");
		return Path.PAGE_ADD_MANAGER;
	}
}
