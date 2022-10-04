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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ViewListCarsCommand extends Command {

	private static final Logger LOG = Logger.getLogger(ViewListCarsCommand.class);

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ViewListCarsCommand starts");

		List<Car> cars = DaoFactory.getCarDaoInstance().findCars();

		LOG.trace("Found in DB: cars --> " + cars);

		request.setAttribute("carsList", cars);
		LOG.trace("Set the request attribute: carsList --> " + cars);

		LOG.debug("ViewListCarsCommand finished");
		return Path.PAGE_LIST_CARS_SORT;

	}
}
