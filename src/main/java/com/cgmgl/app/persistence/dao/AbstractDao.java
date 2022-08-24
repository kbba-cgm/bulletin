package com.cgmgl.app.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<K extends Serializable, E> {
	private final Class<E> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}
	
	@Autowired
	SessionFactory sessionFactroy;
	
	protected Session getSession() {
		return sessionFactroy.getCurrentSession();
	}
	
	protected E getById(long id) {
		return getSession().get(persistentClass, id);
	}
	
	protected Serializable create(E entity) {
		return getSession().save(entity);
	}
	
	protected void update(E entity) {
		getSession().update(entity);
	}
	

	protected void delete(E entity) {
		getSession().delete(entity);
	}
	
	protected void deleteById(long id) {
		getSession().delete(getById(id));
	}
	
	protected CriteriaQuery<E> getCriteriaQuery() {
		return getSession().getCriteriaBuilder().createQuery(persistentClass);
	}
	
	@SuppressWarnings({ "unchecked" })
	protected Query<E> createQuery(String query) {
		return getSession().createQuery(query);
	}
}


