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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListCarsCommand extends Command {

	private static final Logger LOG = Logger.getLogger(ListCarsCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ListCarCommand starts");

		List<Car> cars = DaoFactory.getCarDaoInstance().findCars();
		LOG.trace("Found in DB: cars --> " + cars);

		String sortCommand = request.getParameter("sort");

		if (sortCommand.equalsIgnoreCase("price")) {
			cars.sort(Comparator.comparingInt(Car::getPrice));
		} else if (sortCommand.equalsIgnoreCase("model")) {
			cars.sort(Comparator.comparing(Car::getModel));
		}

		request.setAttribute("carsList", cars);
		LOG.trace("Set the request attribute: carsList --> " + cars);

		LOG.debug("ListCarCommand finished");
		return Path.PAGE_LIST_CARS_SORT;
	}
}
