package web.command;

import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewAddCarCommand extends Command {

	private static final long serialVersionUID = -5788346932961037607L;

	private static final Logger LOG = Logger.getLogger(ViewAddCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewAddCarCommand starts");
		LOG.debug("ViewAddCarCommand finished");
		return Path.PAGE_ADD_CAR;
	}
}
