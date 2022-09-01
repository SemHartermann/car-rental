package web.command;

import db.DBManager;
import db.dao.DaoFactory;
import db.entities.Car;
import epam.zhivotov.app.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * List cars command.
 * 
 * @author A.Yegorov
 *
 */
public class ListCarsCommand extends Command {

	private static final long serialVersionUID = -2944053832470658789L;

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

		request.setAttribute("carsList", cars);
		LOG.trace("Set the request attribute: carsList --> " + cars);

		LOG.debug("ListCarCommand finished");
		return Path.PAGE_LIST_CARS_SORT;
	}
}
