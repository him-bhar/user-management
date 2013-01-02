package com.himanshu.um.api.manager;

import com.himanshu.um.api.privileges.Privilege;
import com.himanshu.um.api.role.Role;
import com.himanshu.um.api.user.User;

/**
 * @author himanshu
 *
 */
public interface IManager {
	/**
	 * This method is used to create a new User
	 * @param user
	 */
	public void addNewUser (User user);
	/**
	 * This method is used to create a new Role
	 * @param role
	 */
	public void addNewRole (Role role);
	/**
	 * This method is used to create a new Privilege
	 * @param privilege
	 */
	public void addNewPrivilege (Privilege privilege);
	/**
	 * This method is used to update an existing User
	 * @param user
	 */
	public void updateNewUser (User user);
	/**
	 * This method is used to update an existing Role
	 * @param role
	 */
	public void updateNewRole (Role role);
	/**
	 * This method is used to update an existing Privilege
	 * @param privilege
	 */
	public void updateNewPrivilege (Privilege privilege);
}
