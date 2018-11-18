package org.orion.app.configuration.persistance;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.orion.app.configuration.ConfigurationProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class HibernateConfiguration {

    protected SessionFactory sessionFactory;
    protected Configuration configuration;

    private Map<String ,String> configProperties;

    public abstract void configure();

    public void addClass(Class type) {

        configuration.addAnnotatedClass(type);
    }

    public void buildSessionFactory() {

        sessionFactory = configuration.buildSessionFactory();
    }

    public SessionFactory sessionFactory() {
        return sessionFactory;
    }

    public Map<String, String> getConfigProperties() {

        configProperties = new HashMap<>();

        try {

            ConfigurationProperties configurationProperties = new ConfigurationProperties();
            configProperties = configurationProperties.getValues();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProperties;
    }
}
