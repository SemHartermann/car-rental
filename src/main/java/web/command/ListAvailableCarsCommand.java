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


public class ListAvailableCarsCommand extends Command {

	private static final long serialVersionUID = -8877189976158489449L;

	private static final Logger LOG = Logger
			.getLogger(ListAvailableCarsCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("ListAvailableCarsCommand starts");

		List<Car> cars = DaoFactory.getCarDaoInstance().findAvailableCars();
		LOG.trace("Found in DB: availableCarsList --> " + cars);

		String sortCommand = request.getParameter("sort");

		if (sortCommand.equalsIgnoreCase("price")) {
			Collections.sort(cars, new Comparator<Car>() {
				public int compare(Car c1, Car c2) {
					return c1.getPrice() - c2.getPrice();
				}
			});
		} else if (sortCommand.equalsIgnoreCase("name")) {
			Collections.sort(cars, new Comparator<Car>() {
				public int compare(Car c1, Car c2) {
					return c1.getModel().compareTo(c2.getModel());
				}
			});
		}
			

		request.setAttribute("availableCarsList", cars);
		LOG.trace("Set the request attribute: availableCarsList --> " + cars);

		LOG.debug("ListAvailableCarsCommand finished");
		return Path.PAGE_LIST_AVAILABLE_CARS;
	}

}
