package db.entities.enums;

import db.entities.User;

/**
 * Role entity.
 * 
 * @author A.Yegorov
 *
 */

public enum Role {

	ADMIN, MANAGER, CLIENT;
	
	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
}
