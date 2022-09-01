package web.command;

import db.dao.DaoFactory;
import db.entities.Car;
import Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Selection car by mark/class command.
 * 
 * @author A.Yegorov
 *
 */
public class SelectionCarCommand extends Command {

	private static final long serialVersionUID = 9075004413679639935L;

	private static final Logger LOG = Logger.getLogger(ListCarsCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("SelectionCarCommand starts");

		List<Car> cars = DaoFactory.getCarDaoInstance().findAvailableCars();
		LOG.trace("Found in DB: cars --> " + cars);

		List<Car> selectCars = new ArrayList<Car>();

		String selectByMark = request.getParameter("selectionByMark");
		LOG.trace("Found in DB: selectByMark --> " + selectByMark);
		String selectByClass = request.getParameter("selectionByClass");
		LOG.trace("Found in DB: selectByClass --> " + selectByClass);

		if (selectByMark.equalsIgnoreCase("-")) {
			for (Car car : cars) {
				if (car.getCarClass().equalsIgnoreCase(selectByClass)) {
					selectCars.add(car);
				}
			}
		} else if (selectByClass.equalsIgnoreCase("-")) {
			for (Car car : cars) {
				if (car.getMark().equalsIgnoreCase(selectByMark)) {
					selectCars.add(car);
				}
			}
		}

		request.setAttribute("selectCars", selectCars);
		LOG.trace("Set the request attribute: selectCars --> " + selectCars);

		LOG.debug("SelectionCarCommand finished");
		return Path.PAGE_SORT_BY_SOMETHING;
	}
}
