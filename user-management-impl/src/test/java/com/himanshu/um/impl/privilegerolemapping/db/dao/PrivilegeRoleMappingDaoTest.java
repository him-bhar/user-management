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
package com.himanshu.um.impl.privilegerolemapping.db.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.himanshu.um.impl.privileges.dao.PrivilegeDao;
import com.himanshu.um.impl.privileges.db.Privilege;
import com.himanshu.um.impl.role.dao.RoleDao;
import com.himanshu.um.impl.role.db.Role;

public class PrivilegeRoleMappingDaoTest {
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

}
