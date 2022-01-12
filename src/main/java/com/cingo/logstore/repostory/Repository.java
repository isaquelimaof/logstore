package com.cingo.logstore.repostory;

import com.cingo.logstore.jpa.*;

import javax.persistence.EntityManager;

public class Repository {

	private EntityManager manager;
	
	public EntityManager getManager() {
		if (manager == null){
			manager = LogStoreEntityManagerFactory.getInstance().createEntityManager();
		}
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void add(Object o) {
		this.getManager().getTransaction().begin();
		this.getManager().persist(o);
		this.getManager().getTransaction().commit();
	}
	
	public void update(Object o) {
		this.getManager().getTransaction().begin();
		this.getManager().merge(o);
		this.getManager().getTransaction().commit();
	}

}
