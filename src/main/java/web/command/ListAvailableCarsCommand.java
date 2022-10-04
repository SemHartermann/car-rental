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
import java.util.*;
import java.util.stream.Collectors;


public class ListAvailableCarsCommand extends Command {


    private static final Logger LOG = Logger
            .getLogger(ListAvailableCarsCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException,
            AppException {
        LOG.debug("ListAvailableCarsCommand starts");

        List<Car> cars = DaoFactory.getCarDaoInstance().findAvailableCars();;

        LOG.trace("Found in DB: cars --> " + cars);

        Set<String> selectCarsClass = new HashSet<>();
        for (Car car : cars) {
            selectCarsClass.add(car.getCarClass());
        }

        request.setAttribute("selectCarsClass", selectCarsClass);
        LOG.trace("Set the request attribute: selectCarsClass --> "
                + selectCarsClass);

        Set<String> selectCarsMark = new HashSet<>();
        for (Car car : cars) {
            selectCarsMark.add(car.getMark());
        }

        request.setAttribute("selectCarsMark", selectCarsMark);
        LOG.trace("Set the request attribute: selectCarsMark --> "
                + selectCarsMark);
        LOG.trace("Found in DB: availableCarsList --> " + cars);

        String sortCommand = request.getParameter("sort");

        String selectByMark = request.getParameter("selectionByMark");
        LOG.trace("Found in DB: selectByMark --> " + selectByMark);
        String selectByClass = request.getParameter("selectionByClass");
        LOG.trace("Found in DB: selectByClass --> " + selectByClass);

        if (selectByClass.equals("-") && selectByMark.equals("-")) {

        } else if (!selectByMark.equals("-")){
            cars = cars.stream()
                    .filter(car -> car.getMark().equals(selectByMark))
                    .collect(Collectors.toList());
        } else {
            cars = cars.stream()
                    .filter(c -> c.getCarClass().equals(selectByClass))
                    .collect(Collectors.toList());
        }


        LOG.trace("Set the request attribute: selectCars --> " + cars);


        if (sortCommand.equalsIgnoreCase("price")) {
            cars.sort(Comparator.comparingInt(Car::getPrice));
        } else if (sortCommand.equalsIgnoreCase("name")) {
            cars.sort(Comparator.comparing(Car::getModel));
        }


        request.setAttribute("availableCarsList", cars);
        LOG.trace("Set the request attribute: availableCarsList --> " + cars);

        LOG.debug("ListAvailableCarsCommand finished");
        return Path.PAGE_LIST_AVAILABLE_CARS;
    }

}
