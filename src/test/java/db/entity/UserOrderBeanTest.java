package db.entity;

import static org.junit.Assert.*;

import java.sql.Date;

import db.entities.UserOrderBean;
import org.junit.Test;


public class UserOrderBeanTest {

	@Test
	public final void testConstructor() {
		new UserOrderBean();
	}

	@Test
	public void testGetOrderId() {
		UserOrderBean userOrderBean = new UserOrderBean();
		int actual = userOrderBean.getOrderId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetOrderId() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setOrderId(8);
		int actual = userOrderBean.getOrderId();
		int expected = 8;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetUserFirstName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		String actual = userOrderBean.getUserFirstName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUserFirstName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setUserFirstName("Alex");
		String actual = userOrderBean.getUserFirstName();
		String expected = "Alex";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetUserLastName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		String actual = userOrderBean.getUserLastName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUserLastName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setUserLastName("Yegorov");
		String actual = userOrderBean.getUserLastName();
		String expected = "Yegorov";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCarName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		String actual = userOrderBean.getCarName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCarName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setCarName("Camaro");
		String actual = userOrderBean.getCarName();
		String expected = "Camaro";
		assertEquals(expected, actual);
	}

	@Test
	public void testIsDriverStatus() {
		UserOrderBean userOrderBean = new UserOrderBean();
		boolean actual = userOrderBean.isDriverStatus();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDriverStatus() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setDriverStatus(true);
		boolean actual = userOrderBean.isDriverStatus();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetOrderData() {
		UserOrderBean userOrderBean = new UserOrderBean();
		Date actual = userOrderBean.getStartDate();
		Date expected = null;
		assertEquals(expected, actual);
	}

	// @Test
	// public void testSetOrderData() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testGetReturnData() {
		UserOrderBean userOrderBean = new UserOrderBean();
		Date actual = userOrderBean.getEndDate();
		Date expected = null;
		assertEquals(expected, actual);
	}

	// @Test
	// public void testSetReturnData() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testGetOrderPrice() {
		UserOrderBean userOrderBean = new UserOrderBean();
		int actual = userOrderBean.getOrderPrice();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetOrderPrice() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setOrderPrice(900);
		int actual = userOrderBean.getOrderPrice();
		int expected = 900;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetStatusName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		String actual = userOrderBean.getStatusName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStatusName() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setStatusName("opened");
		String actual = userOrderBean.getStatusName();
		String expected = "opened";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetRejectionReason() {
		UserOrderBean userOrderBean = new UserOrderBean();
		String actual = userOrderBean.getRejectionReason();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetRejectionReason() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setRejectionReason("rejectionReason");
		String actual = userOrderBean.getRejectionReason();
		String expected = "rejectionReason";
		assertEquals(expected, actual);
	}

	@Test
	public void testIsDamage() {
		UserOrderBean userOrderBean = new UserOrderBean();
		boolean actual = userOrderBean.isDamage();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDamage() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setDamage(true);
		boolean actual = userOrderBean.isDamage();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPriceForRepairs() {
		UserOrderBean userOrderBean = new UserOrderBean();
		int actual = userOrderBean.getPriceForRepairs();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPriceForRepairs() {
		UserOrderBean userOrderBean = new UserOrderBean();
		userOrderBean.setPriceForRepairs(600);
		int actual = userOrderBean.getPriceForRepairs();
		int expected = 600;
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		UserOrderBean userOrderBean = new UserOrderBean();
		String actual = userOrderBean.toString();
		System.out.println(userOrderBean);
		String expected = "UserOrderBean [orderId=0, userFirstName=null, userLastName=null, "
				+ "carName=null, driverStatus=false, startDate=null, endDate=null, orderPrice=0, "
				+ "statusName=null, rejectionReason=null, damage=false, priceForRepairs=0]";
		assertEquals(expected, actual);
	}

}
