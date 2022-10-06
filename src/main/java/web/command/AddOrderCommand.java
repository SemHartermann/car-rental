package web.command;

import db.dao.DaoFactory;
import db.entities.Car;
import db.entities.Order;
import web.Path;
import db.exceptions.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AddOrderCommand extends Command {


	private static final Logger LOG = Logger.getLogger(AddOrderCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
            AppException {
		LOG.debug("AddOrderCommand starts");
		HttpSession session = request.getSession();

		Order order = new Order();

		int userId = (int) session.getAttribute("userId");
		order.setUserId(userId);
		LOG.trace("Request parameter: userId --> " + order.getUserId());
		LOG.trace("Request parameter: carId --> " + String.valueOf(session.getAttribute("carId")));

		String car_id_s =String.valueOf(session.getAttribute("carId"));

		if (car_id_s == null || car_id_s.isEmpty()) {
			String errorMessasge = "CarId cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("AddOrderCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		int carId = Integer.parseInt(car_id_s);
		order.setCarId(carId);
		LOG.trace("Request parameter: carId --> " + order.getCarId());

		Car car = DaoFactory.getCarDaoInstance().findCarById(carId);
		LOG.trace("Found in DB: car --> " + car);
		if (car == null) {
			String errorMessasge = "Car in DB not found";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("RejectOrderCommand finished");
			return Path.PAGE_ERROR_PAGE;
		}

		List<Car> carsInRent = DaoFactory.getCarDaoInstance().findCarsInRent();
		for (int i = 0; i < carsInRent.size(); i++) {
			int id = carsInRent.get(i).getId();
			if (carId == id) {
				String errorMessasge = "This car in rent";
				session.setAttribute("errorMessage", errorMessasge);
				LOG.error("Set the session attribute: errorMessage --> "
						+ errorMessasge);
				LOG.debug("AddOrderCommand finished");
				return Path.PAGE_ERROR_PAGE;
			}
		}

		String status = request.getParameter("driverStatus");
		boolean driverStatus = true;
		if (status == null) {
			driverStatus = false;
		}
		order.setDriverStatus(driverStatus);
		LOG.trace("Request parameter: driverStatus --> "
				+ order.isDriverStatus());

		String startDateS = request.getParameter("startDate");
		String endDateS = request.getParameter("endDate");

		if (startDateS == null || startDateS.isEmpty() || endDateS == null
				|| endDateS.isEmpty()) {
			String errorMessasge = "Date cannot be empty";
			session.setAttribute("errorMessage", errorMessasge);
			LOG.error("Set the session attribute: errorMessage --> "
					+ errorMessasge);
			LOG.debug("AddOrderCommand finished");
			return web.Path.PAGE_ERROR_PAGE;
		}

		Date startDate = Date.valueOf(startDateS);
		order.setStartDate(startDate);
		LOG.trace("Request parameter: startDate --> " + order.getStartDate());

		Date endDate = Date.valueOf(endDateS);
		order.setEndDate(endDate);
		LOG.trace("Request parameter: endDate --> " + order.getEndDate());

		order.setStatusId(0);
		LOG.trace("Request parameter: statusId --> " + order.getStatusId());

		DaoFactory.getOrderDaoInstance().addOrder(order);
		LOG.trace("Create new order --> " + order);

		List<Order> orders = DaoFactory.getOrderDaoInstance().findOrdersByUserId(userId);

		Collections.sort(orders, (o1, o2) -> o2.getId() - o1.getId());

		Order getOrder = orders.get(0);
		int orderId = getOrder.getId();
		int price = getOrder.getPrice();

		session.setAttribute("price", price);
		LOG.trace("Set the session attribute: price --> " + price);

		session.setAttribute("orderId", orderId);
		LOG.trace("Set the session attribute: orderId --> " + orderId);

		LOG.debug("AddOrderCommand finished");
		return Path.PAGE_CLIENT;
	}
}
