package org.orion.app.listener;

import org.hibernate.SessionFactory;
import org.orion.app.configuration.persistance.HibernateConfiguration;
import org.orion.app.configuration.persistance.HibernateMysqlConfiguration;
import org.orion.app.entity.Account;
import org.orion.app.extractor.implementation.AccountExtractor;
import org.orion.app.repository.implementation.AccountRepository;
import org.orion.app.validator.implement.RegistrationValidator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContainerServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        HibernateConfiguration configuration = new HibernateMysqlConfiguration();

        configuration.configure();

        //ajout des tables
        configuration.addClass(Account.class);

        configuration.buildSessionFactory();

        SessionFactory sessionFactory = configuration.sessionFactory();

        AccountRepository accountRepository = new AccountRepository(sessionFactory);
        AccountExtractor accountExtractor = new AccountExtractor();
        RegistrationValidator registrationValidator = new RegistrationValidator();

        sce.getServletContext().setAttribute("sessionFactory",sessionFactory);
        sce.getServletContext().setAttribute("accountRepository",accountRepository);
        sce.getServletContext().setAttribute("accountExtractor",accountExtractor);
        sce.getServletContext().setAttribute("registrationValidator",registrationValidator);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
