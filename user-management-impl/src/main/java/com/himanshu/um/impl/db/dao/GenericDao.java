package com.himanshu.um.impl.db.dao;

import java.util.List;

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
	public T save(T t) {
		em.persist(t);
		return t;
	}

	public List<T> findAll(Class<T> entityClass) {
		return em.createQuery("from "+entityClass.getCanonicalName()).getResultList();
	}
}
