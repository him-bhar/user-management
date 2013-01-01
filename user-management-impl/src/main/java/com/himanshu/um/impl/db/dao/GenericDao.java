package com.himanshu.um.impl.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class GenericDao<T> {
	
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public T save (T t) {
		System.out.println(em);
		em.persist(t);
		return t;
	}
}
