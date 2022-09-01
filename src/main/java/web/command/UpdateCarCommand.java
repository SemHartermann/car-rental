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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Update car command.
 * 
 * @author A.Yegorov
 *
 */
public class UpdateCarCommand extends Command {

	private static final long serialVersionUID = -237904424337914430L;

	private static final Logger LOG = Logger.getLogger(UpdateCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("UpdateCarCommand starts");

		HttpSession session = request.getSession();

		int carId = Integer.valueOf(request.getParameter("id"));
		LOG.trace("Request parameter: carId --> " + carId);

		Car car = DaoFactory.getCarDaoInstance().findCarById(carId);
		LOG.trace("Found in DB: car --> " + car);

		if (car == null) {
			String errorMessasge = "Car in DB not found";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("UpdateCarCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		String carPriceS = request.getParameter("carPrice");
		String carDriverPriceS = request.getParameter("carDriverPrice");

		if (carPriceS == null || carPriceS.isEmpty() || carDriverPriceS == null
				|| carDriverPriceS.isEmpty()) {
			String errorMessasge = "Price cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("UpdateCarCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		int carPrice = Integer.valueOf(carPriceS);
		car.setPrice(carPrice);
		LOG.trace("Request parameter: carPrice --> " + car.getPrice());

		int carDriverPrice = Integer.valueOf(carDriverPriceS);
		car.setDriverPrice(carDriverPrice);
		LOG.trace("Request parameter: carDriverPrice --> "
				+ car.getDriverPrice());

		DaoFactory.getCarDaoInstance().updateCarPrice(car);
		LOG.trace("Update order car --> " + car);

		LOG.debug("UpdateCarCommand finished");
		return Path.PAGE_ADMIN;
	}
}
