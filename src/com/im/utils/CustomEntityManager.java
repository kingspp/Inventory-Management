package com.im.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomEntityManager {

	@PersistenceContext
	public EntityManager entityManager;

	public void setEntityManager( EntityManager entityManager )
	{
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

}
