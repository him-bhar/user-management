/*
 * Copyright 2013 Himanshu Bhardwaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

package com.himanshu.um.api.manager;

import com.himanshu.um.exceptions.privilege.PrivilegeCreationException;
import com.himanshu.um.exceptions.privilege.PrivilegeModificationException;
import com.himanshu.um.exceptions.role.RoleCreationException;
import com.himanshu.um.exceptions.role.RoleModificationException;
import com.himanshu.um.exceptions.user.UserCreationException;
import com.himanshu.um.exceptions.user.UserModificationException;


/**
 * @author himanshu
 *
 */
public interface IManager {
	/**
	 * This method is used to create a new User
	 * @param user
	 */
	public void addNewUser (com.himanshu.um.api.model.User user) throws UserCreationException;
	/**
	 * This method is used to create a new Role
	 * @param role
	 */
	public void addNewRole (com.himanshu.um.api.model.Role role) throws RoleCreationException;
	/**
	 * This method is used to create a new Privilege
	 * @param privilege
	 */
	public void addNewPrivilege (com.himanshu.um.api.model.Privilege privilege) throws PrivilegeCreationException;
	/**
	 * This method is used to update an existing User
	 * @param user
	 */
	public void updateUser (com.himanshu.um.api.model.User user) throws UserModificationException;
	/**
	 * This method is used to update an existing Role
	 * @param role
	 */
	public void updateRole (com.himanshu.um.api.model.Role role) throws RoleModificationException;
	/**
	 * This method is used to update an existing Privilege
	 * @param privilege
	 */
	public void updatePrivilege (com.himanshu.um.api.model.Privilege privilege) throws PrivilegeModificationException;
	/**
	 * This method is used to map a new Role to a User
	 * @param user
	 * @param role
	 */
	public void mapNewRoleToUser (com.himanshu.um.api.model.User user, com.himanshu.um.api.model.Role role) throws UserModificationException;
	/**
	 * This method is used to map a new Privilege to Role
	 * @param role
	 * @param privilege
	 */
	public void mapNewPrivilegeToRole (com.himanshu.um.api.model.Role role, com.himanshu.um.api.model.Privilege privilege) throws RoleModificationException;
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
	public void deletePrivilegeRole (com.himanshu.um.api.model.Role role, com.himanshu.um.api.model.Privilege privilege);
}
