package com.im.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.im.domain.TransactionDetails;
import com.im.domain.User;
import com.im.utils.CustomEntityManager;

@Repository
@Transactional
public class UserDAOImpl extends CustomEntityManager implements IUserDAO {

    private Query query;
    TransactionDetails transactionDetails = new TransactionDetails();

    public void deleteUser()
    {

    }

    @SuppressWarnings( "unchecked" )
    public List<User> getAllUsersDao()
    {
        query = getEntityManager().createNamedQuery("User.getUsers");
        List<User> list = query.getResultList();
        return list;
    }
}
