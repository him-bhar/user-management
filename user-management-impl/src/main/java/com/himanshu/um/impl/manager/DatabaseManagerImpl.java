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

package com.himanshu.um.impl.manager;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.himanshu.um.api.manager.IManager;
import com.himanshu.um.api.model.Privilege;
import com.himanshu.um.api.model.Role;
import com.himanshu.um.api.model.User;
import com.himanshu.um.exceptions.privilege.PrivilegeCreationException;
import com.himanshu.um.exceptions.privilege.PrivilegeModificationException;
import com.himanshu.um.exceptions.role.RoleCreationException;
import com.himanshu.um.exceptions.role.RoleModificationException;
import com.himanshu.um.exceptions.user.UserCreationException;
import com.himanshu.um.exceptions.user.UserModificationException;
import com.himanshu.um.impl.user.dao.UserDao;


public class DatabaseManagerImpl implements IManager {

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addNewUser(User user) throws UserCreationException {
		com.himanshu.um.impl.user.db.User userDB = new com.himanshu.um.impl.user.db.User();
		userDB.setUsername(user.getUsername());
		userDB.setPassword(user.getPassword());
		userDB.setCreatedDate(new Timestamp(user.getCreatedDate().toGregorianCalendar().getTimeInMillis()));
		userDB.setStatus(user.isStatus());
		userDB.setLastModifiedDate(new Timestamp(user.getLastModifiedDate().toGregorianCalendar().getTimeInMillis()));
		userDao.save(userDB);

	}

	@Override
	public void addNewRole(Role role) throws RoleCreationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewPrivilege(Privilege privilege)
			throws PrivilegeCreationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) throws UserModificationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRole(Role role) throws RoleModificationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrivilege(Privilege privilege)
			throws PrivilegeModificationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void mapNewRoleToUser(User user, Role role)
			throws UserModificationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void mapNewPrivilegeToRole(Role role, Privilege privilege)
			throws RoleModificationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserRole(User user, Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePrivilegeRole(Role role, Privilege privilege) {
		// TODO Auto-generated method stub

	}

}
