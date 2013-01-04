package com.himanshu.um.api.manager;


/**
 * @author himanshu
 *
 */
public interface IManager {
	/**
	 * This method is used to create a new User
	 * @param user
	 */
	public void addNewUser (com.himanshu.um.api.model.User user);
	/**
	 * This method is used to create a new Role
	 * @param role
	 */
	public void addNewRole (com.himanshu.um.api.model.Role role);
	/**
	 * This method is used to create a new Privilege
	 * @param privilege
	 */
	public void addNewPrivilege (com.himanshu.um.api.model.Privilege privilege);
	/**
	 * This method is used to update an existing User
	 * @param user
	 */
	public void updateNewUser (com.himanshu.um.api.model.User user);
	/**
	 * This method is used to update an existing Role
	 * @param role
	 */
	public void updateNewRole (com.himanshu.um.api.model.Role role);
	/**
	 * This method is used to update an existing Privilege
	 * @param privilege
	 */
	public void updateNewPrivilege (com.himanshu.um.api.model.Privilege privilege);
	/**
	 * This method is used to map a new Role to a User
	 * @param user
	 * @param role
	 */
	public void mapNewRoleToUser (com.himanshu.um.api.model.User user, com.himanshu.um.api.model.Role role);
	/**
	 * This method is used to map a new Privilege to Role
	 * @param role
	 * @param privilege
	 */
	public void mapNewPrivilegeToRole (com.himanshu.um.api.model.Role role, com.himanshu.um.api.model.Privilege privilege);
	/**
	 * This method is used to Delete a Role from a User
	 * @param user
	 * @param role
	 */
	public void deleteUserRole (com.himanshu.um.api.model.User user, com.himanshu.um.api.model.Role role);
	/**
	 * This method is used to Delete a Privilege from a Role
	 * @param role
	 * @param privlege
	 */
	public void deleteRolePrivilege (com.himanshu.um.api.model.Role role, com.himanshu.um.api.model.Privilege privilege);
}
