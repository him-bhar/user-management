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

package com.himanshu.um.impl.factory;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.himanshu.logging.AccountLogger;
import com.himanshu.um.api.manager.IManager;
import com.himanshu.um.exceptions.user.UserCreationException;
import com.himanshu.um.impl.manager.DatabaseManagerImpl;
import com.himanshu.um.impl.privileges.dao.PrivilegeDao;
import com.himanshu.um.impl.privileges.db.Privilege;
import com.himanshu.um.impl.role.dao.RoleDao;
import com.himanshu.um.impl.role.db.Role;
import com.himanshu.um.impl.user.dao.UserDao;
import com.himanshu.um.impl.user.db.User;


public class FactoryLoaderTest {

	@Ignore
	@Test
	public void testApplicationContextLoad() {
		ApplicationContext context = new ClassPathXmlApplicationContext("um-spring.xml");

		//EntityManagerFactory emf = (EntityManagerFactory)context.getBean("entityManagerFactory");
		//EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin();
		//em.persist(new User());
		//em.getTransaction().commit();
		UserDao dao = (UserDao)context.getBean("userDao");
		User u = new User();
		u.setUsername("bhardwaj");
		dao.save(u);

	}


	@Ignore
	@Test
	public void testUserRoleMappingLoad() {
		ApplicationContext context = new ClassPathXmlApplicationContext("um-spring.xml");

		UserDao dao = (UserDao)context.getBean("userDao");
		RoleDao roledao = (RoleDao)context.getBean("roleDao");
		User u = new User();
		Role r = new Role();
		roledao.save(r);
		u.addRoleMapping(r);
		dao.save(u);


	}

	@Ignore
	@Test
	public void testRolePrivilegeMappingLoad() {
		ApplicationContext context = new ClassPathXmlApplicationContext("um-spring.xml");

		RoleDao roleDao = (RoleDao)context.getBean("roleDao");
		PrivilegeDao privDao = context.getBean(PrivilegeDao.class);
		Privilege p = new Privilege();
		Role r = new Role();
		roleDao.save(r);
		p.addRoleMapping(r);
		privDao.save(p);


	}

	@Ignore
	@Test
	public void testListAllUsers() {
		ApplicationContext context = new ClassPathXmlApplicationContext("um-spring.xml");

		UserDao userDao = context.getBean(UserDao.class);
		userDao.findAll(User.class);
	}

	@Ignore
	@Test
	public void testLogMessageWithoutMarker() {
		AccountLogger logger = new AccountLogger(getClass(), "testing");
		logger.debug("Test1"); //Since marker is not supplied, hence default value is supplied from discriminator class
	}

	@Test
	public void createUser() throws UserCreationException, DatatypeConfigurationException, InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("um-spring.xml");

		IManager manager = context.getBean(DatabaseManagerImpl.class);
		com.himanshu.um.api.model.User user = new com.himanshu.um.api.model.User();
		user.setUsername("himanshu");
		user.setPassword("password");
		user.setStatus(true);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(new Date().getTime());
		try {
			user.setCreatedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			throw e;
		}

		Thread.sleep(3000);	//3 seconds sleep to demonstrate last modified date lag

		cal.setTimeInMillis(new Date().getTime());
		try {
			user.setLastModifiedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			throw e;
		}


		manager.addNewUser(user);
	}

}
