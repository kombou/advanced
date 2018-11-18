package org.orion.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.orion.app.configuration.persistance.HibernateConfiguration;
import org.orion.app.configuration.persistance.HibernateMysqlConfiguration;
import org.orion.app.entity.Account;

public class HibernateMysqlConfigurationTest {

    @Test
    public void save() {

        HibernateConfiguration configuration = new HibernateMysqlConfiguration();

        configuration.configure();
        configuration.addClass(Account.class);
        configuration.buildSessionFactory();

        Account user = new Account();

        user.setName("KOMBOU");
        user.setSurname("Yvan");
        user.setEmail("yvan.kombou@gmail.com");

        SessionFactory sessionFactory = configuration.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();

        System.out.println("New user Id : " + user.getId());
    }
}
