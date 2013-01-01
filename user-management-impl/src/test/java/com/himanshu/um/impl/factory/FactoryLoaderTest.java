package com.himanshu.um.impl.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.himanshu.um.impl.role.dao.RoleDao;
import com.himanshu.um.impl.role.db.Role;
import com.himanshu.um.impl.user.dao.UserDao;
import com.himanshu.um.impl.user.db.User;


public class FactoryLoaderTest {
	
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
}
