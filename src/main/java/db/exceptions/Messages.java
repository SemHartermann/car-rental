package db.exceptions;

/**
 * Holder for messages of exceptions.
 * 
 * @author A.Yegorov
 *
 */

public class Messages {

	public Messages() {
		// no op
	}

	public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";

	public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";

	public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";

	public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";

	public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";

	public static final String ERR_CANNOT_OBTAIN_USER_ORDER_BEANS = "Cannot obtain user order beans";

	public static final String ERR_CANNOT_OBTAIN_USER_INFO_BEANS = "Cannot obtain user info beans";

	public static final String ERR_CANNOT_OBTAIN_USERS = "Cannot obtain users";

	public static final String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";

	public static final String ERR_CANNOT_OBTAIN_USER_BY_LOGIN = "Cannot obtain a user by its login";

	public static final String ERR_CANNOT_OBTAIN_USER_INFO_BY_ID = "Cannot obtain a userInfo by its id";

	public static final String ERR_CANNOT_OBTAIN_ORDERS = "Cannot obtain orders";

	public static final String ERR_CANNOT_OBTAIN_ORDERS_BY_STATUS_ID = "Cannot obtain orders by status id";

	public static final String ERR_CANNOT_OBTAIN_ORDERS_BY_USER_ID = "Cannot obtain orders by user id";

	public static final String ERR_CANNOT_OBTAIN_ORDERS_BY_CAR_ID = "Cannot obtain orders by car id";

	public static final String ERR_CANNOT_OBTAIN_ORDER_BY_ID = "Cannot obtain orders by id";

	public static final String ERR_CANNOT_OBTAIN_CARS = "Cannot obtain cars";

	public static final String ERR_CANNOT_OBTAIN_CAR_BY_ID = "Cannot obtain cars by id";

	public static final String ERR_CANNOT_UPDATE_USER = "Cannot update a user";

	public static final String ERR_CANNOT_CREATE_USER = "Cannot create a user";

	public static final String ERR_CANNOT_UPDATE_USER_INFO = "Cannot update a info user";

	public static final String ERR_CANNOT_UPDATE_ORDER_PRICE = "Cannot update a order price";

	public static final String ERR_CANNOT_UPDATE_ORDER_STATUS = "Cannot update a order status";

	public static final String ERR_CANNOT_UPDATE_CAR_PRICE = "Cannot update a car price";

	public static final String ERR_CANNOT_UPDATE_CAR = "Cannot update a car";

	public static final String ERR_CANNOT_DELETE_CAR_BY_ID = "Cannot delete a car by id";

	public static final String ERR_CANNOT_CREATE_CAR = "Cannot create a car";

	public static final String ERR_CANNOT_CREATE_ORDER = "Cannot create a order";

}
