package db.entity;

import static org.junit.Assert.*;

import db.entities.UserInfo;
import org.junit.Test;

public class UserInfoTest {

	@Test
	public final void testConstructor() {
		new UserInfo();
	}

	@Test
	public void testGetUserId() {
		UserInfo userInfo = new UserInfo();
		int actual = userInfo.getUserId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUserId() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(4);
		int actual = userInfo.getUserId();
		int expected = 4;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFirstName() {
		UserInfo userInfo = new UserInfo();
		String actual = userInfo.getFirstName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetFirstName() {
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName("Alex");
		String actual = userInfo.getFirstName();
		String expected = "Alex";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLastName() {
		UserInfo userInfo = new UserInfo();
		String actual = userInfo.getLastName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetLastName() {
		UserInfo userInfo = new UserInfo();
		userInfo.setLastName("Yegorov");
		String actual = userInfo.getLastName();
		String expected = "Yegorov";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPassportNumber() {
		UserInfo userInfo = new UserInfo();
		String actual = userInfo.getPassportNumber();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPassportNumber() {
		UserInfo userInfo = new UserInfo();
		userInfo.setPassportNumber("MK236548");
		String actual = userInfo.getPassportNumber();
		String expected = "MK236548";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPhoneNumber() {
		UserInfo userInfo = new UserInfo();
		String actual = userInfo.getPhoneNumber();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPhoneNumber() {
		UserInfo userInfo = new UserInfo();
		userInfo.setPhoneNumber("0507110189");
		String actual = userInfo.getPhoneNumber();
		String expected = "0507110189";
		assertEquals(expected, actual);
	}


	@Test
	public void testToString() {
		UserInfo userInfo = new UserInfo();
		System.out.println(userInfo);
		String actual = userInfo.toString();
		String expected = "UserInfo [userId=0, firstName=null, lastName=null, passportNumber=null, phoneNumber=null, email=null]";
		assertEquals(expected, actual);
	}

}
