package web.command;

import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewDeleteCarCommand extends Command {


	private static final Logger LOG = Logger
			.getLogger(ViewDeleteCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewDeleteCarCommand starts");
		LOG.debug("ViewDeleteCarCommand finished");
		return Path.PAGE_DELETE_CAR;
	}
}
