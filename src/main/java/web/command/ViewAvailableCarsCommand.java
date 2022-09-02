package web.command;

import db.dao.DaoFactory;
import db.entities.Car;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ViewAvailableCarsCommand extends Command {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger
			.getLogger(ViewAvailableCarsCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewAvailableCarsCommand starts");
		
		List<Car> cars = DaoFactory.getCarDaoInstance().findAvailableCars();
		LOG.trace("Found in DB: availableCarsList --> " + cars);
		
		request.setAttribute("availableCarsListById", cars);
		LOG.trace("Set the request attribute: availableCarsListById --> " + cars);
		
		LOG.debug("ViewAvailableCarsCommand finished");
		return Path.PAGE_LIST_AVAILABLE_CARS;
	}
}
