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
 * Add new car command.
 * 
 * @author A.Yegorov
 *
 */
public class AddNewCarCommand extends Command {

	private static final long serialVersionUID = -5788346932961037607L;

	private static final Logger LOG = Logger.getLogger(AddNewCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("AddNewCar starts");
		DBManager manager = DBManager.getInstance();
		HttpSession session = request.getSession();

		Car car = new Car();

		String name = String.valueOf(request.getParameter("name"));
		car.setModel(name);
		LOG.trace("Request parametr: name --> " + car.getModel());

		String mark = String.valueOf(request.getParameter("mark"));
		car.setMark(mark);
		LOG.trace("Request parametr: mark --> " + car.getMark());

		String car_class = String.valueOf(request.getParameter("carClass"));
		car.setCarClass(car_class);
		LOG.trace("Request parametr: car_class --> " + car.getCarClass());

		String car_price_s = request.getParameter("carPrice");
		int car_price = Integer.valueOf(car_price_s);
		car.setPrice(car_price);
		LOG.trace("Request parametr: car_price --> " + car.getPrice());

		String car_driver_price_s = request.getParameter("carDriverPrice");
		int car_driver_price = Integer.valueOf(car_driver_price_s);
		car.setDriverPrice(car_driver_price);
		LOG.trace("Request parametr: car_driver_price --> "
				+ car.getDriverPrice());

		if (name == null || mark == null || car_class == null
				|| car_price_s == null || car_driver_price_s == null
				|| name.isEmpty() || mark.isEmpty() || car_class.isEmpty()
				|| car_price_s.isEmpty() || car_driver_price_s.isEmpty()) {
			String errorMessasge = "empty field";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("AddNewCar finished");
			return Path.PAGE_ERROR_PAGE;
		}

		DaoFactory.getCarDaoInstance().addCar(car);
		LOG.trace("Create new car --> " + car);

		LOG.debug("AddNewCar finished");
		return Path.PAGE_ADMIN;
	}

}
