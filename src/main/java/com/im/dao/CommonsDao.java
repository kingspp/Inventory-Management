package com.im.dao;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.im.utils.CustomEntityManager;

@Repository
@Transactional
public class CommonsDao extends CustomEntityManager {

    public void persistObject( Object object )
    {
        getEntityManager().persist(object);
    }
    
    public void mergeObject(Object ob)
    {
    	getEntityManager().merge(ob);
    }

}
