package org.orion.app.repository.implementation;

import org.hibernate.SessionFactory;
import org.orion.app.entity.Account;
import org.orion.app.repository.contract.IAccountRepository;

public class AccountRepository extends Repository<Account,Integer>  implements IAccountRepository{

    public AccountRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
