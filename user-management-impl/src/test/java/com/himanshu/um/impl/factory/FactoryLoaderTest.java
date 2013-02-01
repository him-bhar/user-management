package com.himanshu.um.impl.factory;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

	@Test
	public void testListAllUsers() {
		ApplicationContext context = new ClassPathXmlApplicationContext("um-spring.xml");

		UserDao userDao = context.getBean(UserDao.class);
		userDao.findAll(User.class);
	}
}
