package db.entity;

import static org.junit.Assert.*;

import java.sql.Date;

import db.entities.Order;
import org.junit.Test;

public class OrderTest {

	@Test
	public final void testConstructor() {
		new Order();
	}

	@Test
	public void testGetUserId() {
		Order order = new Order();
		int actual = order.getUserId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUserId() {
		Order order = new Order();
		order.setUserId(6);
		int actual = order.getUserId();
		int expected = 6;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCarId() {
		Order order = new Order();
		int actual = order.getCarId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCarId() {
		Order order = new Order();
		order.setCarId(8);
		int actual = order.getCarId();
		int expected = 8;
		assertEquals(expected, actual);
	}

	@Test
	public void testIsDriverStatus() {
		Order order = new Order();
		boolean actual = order.isDriverStatus();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDriverStatus() {
		Order order = new Order();
		order.setDriverStatus(true);
		boolean actual = order.isDriverStatus();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetOrderData() {
		Order order = new Order();
		Date actual = order.getStartDate();
		Date expected = null;
		assertEquals(expected, actual);
	}

//	@Test
//	public void testSetOrderData() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetReturnData() {
		Order order = new Order();
		Date actual = order.getEndDate();
		Date expected = null;
		assertEquals(expected, actual);
	}

//	@Test
//	public void testSetReturnData() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetOrderPrice() {
		Order order = new Order();
		int actual = order.getPrice();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetOrderPrice() {
		Order order = new Order();
		order.setPrice(5000);
		int actual = order.getPrice();
		int expected = 5000;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetStatusId() {
		Order order = new Order();
		int actual = order.getStatusId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStatusId() {
		Order order = new Order();
		order.setStatusId(3);
		int actual = order.getStatusId();
		int expected = 3;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetRejectionReason() {
		Order order = new Order();
		String actual = order.getRejectionReason();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetRejectionReason() {
		Order order = new Order();
		order.setRejectionReason("rejectionReason");
		String actual = order.getRejectionReason();
		String expected = "rejectionReason";
		assertEquals(expected, actual);
	}

	@Test
	public void testIsDamage() {
		Order order = new Order();
		boolean actual = order.isDamage();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDamage() {
		Order order = new Order();
		order.setDamage(true);
		boolean actual = order.isDamage();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPriceForRepairs() {
		Order order = new Order();
		int actual = order.getPriceForRepairs();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPriceForRepairs() {
		Order order = new Order();
		order.setPriceForRepairs(150);
		int actual = order.getPriceForRepairs();
		int expected = 150;
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		Order order = new Order();
		String actual = order.toString();
		String expected = "Order [userId=0, carId=0, driverStatus=false, startDate=null, "
				+ "endDate=null, price=0, statusId=0, rejectionReason=null, damage=false, "
				+ "priceForRepairs=0]";
		assertEquals(expected, actual);
	}

}
