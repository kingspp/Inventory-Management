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
    public List<Inventory> getAllInventories() throws Exception
    {
        query = getEntityManager().createNamedQuery("Inventory.getInventories");
        return query.getResultList();

    }

    @Override
    public List<TransactionDetails> getTransactions()
    {
        query = getEntityManager().createNamedQuery("TransactionDetails.getTransactions");
        return query.getResultList();
    }
}
