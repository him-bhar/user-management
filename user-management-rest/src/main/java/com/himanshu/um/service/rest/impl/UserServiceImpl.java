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

package com.himanshu.um.service.rest.impl;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.himanshu.um.api.model.User;
import com.himanshu.um.api.model.UserTO;
import com.himanshu.um.impl.user.dao.UserDao;
import com.himanshu.um.service.interfaces.UserService;


@Path("/user-service/")
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@GET
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_XML)
	public UserTO getUser(@PathParam("name") String name) {
		User u = new User();
		UserTO userTo = new UserTO();
		userTo.setUser(u);
		return userTo;
	}

	@GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
	public List<UserTO> getAllUsers() throws DatatypeConfigurationException {
		/*List<UserTO> userList = new ArrayList<UserTO>();
		UserTO userTo1 = new UserTO();
		User u1 = new User();
		u1.setUsername("himanshu");
		userTo1.setUser(u1);
		userList.add(userTo1);

		UserTO userTo2 = new UserTO();
		User u2 = new User();
		u2.setUsername("bhardwaj");
		userTo2.setUser(u2);
		userList.add(userTo2);

		return userList;*/
		List<UserTO> userList = new ArrayList<UserTO>();
		List<com.himanshu.um.impl.user.db.User> userListDb = getUserDao().findAll(com.himanshu.um.impl.user.db.User.class);
		for (com.himanshu.um.impl.user.db.User userDb : userListDb) {
			userList.add(convertUserToUserTO(userDb));
		}
		return userList;
	}

	private UserTO convertUserToUserTO(com.himanshu.um.impl.user.db.User userDb) throws DatatypeConfigurationException {
		User user = new User();
		user.setUsername(userDb.getUsername());
		user.setStatus(userDb.isStatus());
		user.setPassword(userDb.getPassword());
		//user.setCreatedDate(Calendar.getInstance().setTimeInMillis(userDb.getCreatedDate().getTime()));
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(userDb.getCreatedDate().getTime());
		try {
			user.setCreatedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			throw e;
		}
		UserTO userTO = new UserTO();
		userTO.setUser(user);
		return userTO;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
