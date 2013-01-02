package com.himanshu.um.impl.factory;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		dao.save(new User());
		RoleDao roledao = (RoleDao)context.getBean("roleDao");
		roledao.save(new Role());

	}


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
}
