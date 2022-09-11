package web.command;

import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewUpdateCarCommand extends Command {

	private static final Logger LOG = Logger
			.getLogger(ViewUpdateCarCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewUpdateCarCommand starts");
		LOG.debug("ViewUpdateCarCommand finished");
		return Path.PAGE_UPDATE_CAR;
	}
}
