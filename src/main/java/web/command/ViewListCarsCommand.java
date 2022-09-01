package web.command;

import epam.zhivotov.app.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * View list cars command.
 * 
 * @author A.Yegorov
 *
 */
public class ViewListCarsCommand extends Command {

	private static final long serialVersionUID = 542160985642352754L;

	private static final Logger LOG = Logger
			.getLogger(ViewListCarsCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewListCarsCommand starts");
		LOG.debug("ViewListCarsCommand finished");
		return Path.PAGE_LIST_CARS_SORT;

	}
}
