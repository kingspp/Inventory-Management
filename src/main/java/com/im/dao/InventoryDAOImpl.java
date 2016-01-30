package com.im.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;
import com.im.utils.CustomEntityManager;
import com.im.utils.JSONResponse;

@Repository
@Transactional
@SuppressWarnings( "unchecked" )
public class InventoryDAOImpl extends CustomEntityManager implements IInventoryDAO {

    Query query = null;

    @Autowired
    JSONResponse jsonResponse;

    @Override
    public List<Inventory> getAllInventories()
    {
        query = getEntityManager().createNamedQuery("Inventory.getAllInventories");
        return query.getResultList();

    }

    @Override
    public List<TransactionDetails> getTransactions()
    {
        query = getEntityManager().createNamedQuery("TransactionDetails.getTransactions");
        return query.getResultList();
    }

	@Override
	public List<Inventory> getFreeInventories()
	{
		query = getEntityManager().createNamedQuery("Inventory.getFreeInventories");
        return query.getResultList();
	}

	@Override
	public List<Inventory> getInventoryForUser( Integer userId )
	{
		query = getEntityManager().createNamedQuery("Inventory.getInventoryForUser");
		query.setParameter("userId", userId);
        return query.getResultList();
	}

	@Override
	public List<Inventory> getInventoryForId( Integer inventoryId )
	{
		query = getEntityManager().createNamedQuery("Inventory.getInventoryForId");
		query.setParameter("inventoryId", inventoryId);
		return query.getResultList();
	}
	
	
}
