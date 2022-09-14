package db.entity;

import static org.junit.Assert.*;

import db.entities.User;
import org.junit.Test;

public class UserTest {

	@Test
	public final void testConstructor() {
		new User();
	}

	@Test
	public void testGetRoleId() {
		User user = new User();
		int actual = user.getRoleId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetRoleId() {
		User user = new User();
		user.setRoleId(2);
		int actual = user.getRoleId();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLogin() {
		User user = new User();
		String actual = user.getEmail();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetLogin() {
		User user = new User();
		user.setEmail("email@mail");
		String actual = user.getEmail();
		String expected = "email@mail";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPassword() {
		User user = new User();
		String actual = user.getPassword();
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPassword() {
		User user = new User();
		user.setPassword("Rs87t");
		String actual = user.getPassword();
		String expected = "Rs87t";
		assertEquals(expected, actual);
	}

	@Test
	public void testIsStatus() {
		User user = new User();
		boolean actual = user.isStatus();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStatus() {
		User user = new User();
		user.setStatus(true);
		boolean actual = user.isStatus();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void testToString() {
		User user = new User();
		String actual = user.toString();
		String expected = "User [roleId=0, email=null, password=null, status=false]";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetId() {
		User user = new User();
		int actual = user.getId();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testSetId() {
		User user = new User();
		user.setId(5);
		int actual = user.getId();
		int expected = 5;
		assertEquals(expected, actual);
	}

}
