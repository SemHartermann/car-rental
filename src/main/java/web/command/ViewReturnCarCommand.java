package web.command;

import epam.zhivotov.app.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * View return car command.
 * 
 * @author A.Yegorov
 *
 */
public class ViewReturnCarCommand extends Command {

	private static final long serialVersionUID = -39161132321687163L;

	private static final Logger LOG = Logger
			.getLogger(ViewReturnCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewReturnCarCommand starts");
		LOG.debug("ViewReturnCarCommand finished");
		return Path.PAGE_RETURN_ORDER;
	}
}
