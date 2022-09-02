package web.command;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

	private static final Logger LOG = Logger.getLogger(CommandContainer.class);

	private static Map<String, Command> commands = new TreeMap<String, Command>();

	static {
		// common commands
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("noCommand", new NoCommand());
		commands.put("changeLocale", new ChangeLocaleCommand());
		commands.put("viewLocale", new ViewLocaleCommand());
		
		
		

		// client commands
		commands.put("registerClient", new RegisterCommand());
		commands.put("viewAddUserInfo", new ViewAddUserInfoCommand());
		commands.put("addUserInfo", new AddUserInfoCommand());
		commands.put("client", new ClientCommand());
		commands.put("addOrder", new AddOrderCommand());
		commands.put("payment", new PaymentCommand());
		commands.put("viewAvailableCars", new ViewAvailableCarsCommand());
		commands.put("availableCarsList", new ListAvailableCarsCommand());
		commands.put("updateUserInfo", new UpdateUserInfoCommand());
		commands.put("viewUpdateUserInfo", new ViewUpdateUserInfoCommand());
		commands.put("listOrdersByUserId", new ListOrdersByUserIdCommand());
		commands.put("selectBySomething", new ViewSelectionCommand());
		commands.put("selectCarsSel", new SelectionCarCommand());
		commands.put("viewListCars", new ViewListCarsCommand());

		// admin commands
		commands.put("addCar", new AddNewCarCommand());
		commands.put("carsList", new ListCarsCommand());
		commands.put("addNewManager", new AddManagerCommand());
		commands.put("orderList", new GetOrdersListCommand());
		commands.put("userList", new ListUsersCommand());
		commands.put("userInfoBeanList", new ListClientInfoCommand());
		commands.put("viewAddCar", new ViewAddCarCommand());
		commands.put("viewAddManager", new ViewAddManagerCommand());
		commands.put("admin", new AdminCommand());
		commands.put("deleteCarById", new DeleteCarByIdCommand());
		commands.put("viewDeleteCar", new ViewDeleteCarCommand());
		commands.put("changeUserStatus", new ChangeUserStatusCommand());
		commands.put("viewChangeUserStatus", new ViewChangeUserStatusCommand());
		commands.put("viewUpdateCar", new ViewUpdateCarCommand());
		commands.put("updateCar", new UpdateCarCommand());

		// manager commands
		commands.put("manager", new ManagerCommand());
		commands.put("userOrderBeanList", new ListOrdersCommand());
		commands.put("rejectOrder", new RejectOrderCommand());
		commands.put("viewRejectOrder", new ViewRejectOrderCommand());
		commands.put("returnCar", new ReturnCarCommand());
		commands.put("viewReturnCar", new ViewReturnCarCommand());
		commands.put("confirmOrder", new ConfirmOrderCommand());
		commands.put("viewConfirmOrder", new ViewConfirmOrderCommand());

		LOG.debug("Command container was successfully initialized");
		LOG.trace("Number of commands --> " + commands.size());
	}

	/**
	 * Returns command object with the given name.
	 * 
	 * @param commandName
	 *            Name of the command.
	 * @return Command object.
	 */
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command not found, name --> " + commandName);
			return commands.get("noCommand");
		}
		return commands.get(commandName);
	}

}
