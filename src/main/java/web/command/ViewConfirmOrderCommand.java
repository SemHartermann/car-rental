package web.command;

import epam.zhivotov.app.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * View confirm order command.
 * 
 * @author A.Yegorov
 *
 */
public class ViewConfirmOrderCommand extends Command {

	private static final long serialVersionUID = 931883019715036684L;

	private static final Logger LOG = Logger
			.getLogger(ViewRejectOrderCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewConfirmOrderCommand starts");
		LOG.debug("ViewConfirmOrderCommand finished");
		return Path.PAGE_CONFIRM_ORDER;
	}
}
