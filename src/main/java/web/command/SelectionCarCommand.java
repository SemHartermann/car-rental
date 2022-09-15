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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionCarCommand extends Command {

	private static final Logger LOG = Logger.getLogger(ListCarsCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("SelectionCarCommand starts");

		List<Car> cars = DaoFactory.getCarDaoInstance().findAvailableCars();
		LOG.trace("Found in DB: cars --> " + cars);

		List<Car> selectCars;

		String selectByMark = request.getParameter("selectionByMark");
		LOG.trace("Found in DB: selectByMark --> " + selectByMark);
		String selectByClass = request.getParameter("selectionByClass");
		LOG.trace("Found in DB: selectByClass --> " + selectByClass);

		selectCars = cars.stream()
				.filter(c->c.getCarClass().equals(selectByClass))
				.filter(car -> car.getMark().equals(selectByMark))
				.collect(Collectors.toList());


		request.setAttribute("selectCars", selectCars);
		LOG.trace("Set the request attribute: selectCars --> " + selectCars);

		LOG.debug("SelectionCarCommand finished");
		return Path.PAGE_SORT_BY_SOMETHING;
	}
}
