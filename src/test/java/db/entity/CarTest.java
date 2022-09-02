package db.entity;

import static org.junit.Assert.*;

import db.entities.Car;
import org.junit.Test;

public class CarTest {

	@Test
	public final void testConstructor() {
		new Car();
	}

	@Test
	public void testGetName() {
		Car car = new Car();
		String actual = car.getModel();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetName() {
		Car car = new Car();
		car.setModel("Camaro");
		String actual = car.getModel();
		String expected = "Camaro";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetMark() {
		Car car = new Car();
		String actual = car.getMark();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMark() {
		Car car = new Car();
		car.setMark("Chevrolet");
		String actual = car.getMark();
		String expected = "Chevrolet";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCarClass() {
		Car car = new Car();
		String actual = car.getCarClass();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCarClass() {
		Car car = new Car();
		car.setCarClass("S");
		String actual = car.getCarClass();
		String expected = "S";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCarPrice() {
		Car car = new Car();
		int actual = car.getCarPrice();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCarPrice() {
		Car car = new Car();
		car.setCarPrice(5000);
		int actual = car.getCarPrice();
		int expected = 5000;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCarDriverPrice() {
		Car car = new Car();
		int actual = car.getCarDriverPrice();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCarDriverPrice() {
		Car car = new Car();
		car.setCarDriverPrice(5200);
		int actual = car.getCarDriverPrice();
		int expected = 5200;
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		Car car = new Car();
		String actual = car.toString();
		String expected = "Car [name=null, mark=null, carClass=null, carPrice=0, carDriverPrice=0]";
		assertEquals(expected, actual);
	}

}
