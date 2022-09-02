package db.entity;

import static org.junit.Assert.*;

import db.entities.UserInfoBean;
import org.junit.Test;


public class UserInfoBeanTest {

	@Test
	public final void testConstructor() {
		new UserInfoBean();
	}

	@Test
	public void testGetUserId() {
		UserInfoBean userIB = new UserInfoBean();
		int actual = userIB.getUserId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUserId() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setUserId(9);
		int actual = userIB.getUserId();
		int expected = 9;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLogin() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.getLogin();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetLogin() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setLogin("login");
		String actual = userIB.getLogin();
		String expected = "login";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPassword() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.getPassword();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPassword() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setPassword("Pojk56");
		String actual = userIB.getPassword();
		String expected = "Pojk56";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFirstName() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.getFirstName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetFirstName() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setFirstName("Alex");
		String actual = userIB.getFirstName();
		String expected = "Alex";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLastName() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.getLastName();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetLastName() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setLastName("Yegorov");
		String actual = userIB.getLastName();
		String expected = "Yegorov";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPassportNumber() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.getPassportNumber();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPassportNumber() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setPassportNumber("MB265478");
		String actual = userIB.getPassportNumber();
		String expected = "MB265478";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPhoneNumber() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.getPhoneNumber();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPhoneNumber() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setPhoneNumber("0507110189");
		String actual = userIB.getPhoneNumber();
		String expected = "0507110189";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetEmail() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.getEmail();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetEmail() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setEmail("yegorov@gmail.com");
		String actual = userIB.getEmail();
		String expected = "yegorov@gmail.com";
		assertEquals(expected, actual);
	}

	@Test
	public void testIsStatus() {
		UserInfoBean userIB = new UserInfoBean();
		boolean actual = userIB.isStatus();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStatus() {
		UserInfoBean userIB = new UserInfoBean();
		userIB.setStatus(true);
		boolean actual = userIB.isStatus();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		UserInfoBean userIB = new UserInfoBean();
		String actual = userIB.toString();
		String expected = "UserInfoBean [userId=0, login=null, password=null, firstName=null, "
				+ "lastName=null, passportNumber=null, phoneNumber=null, email=null, status=false]";
		assertEquals(expected, actual);
	}

}
