package com.intellisoft.autopartsstore.hibernateconfig.hibernateutil;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Сирожа и Маха on 30.07.2017.
 */
public class HibernateSessionFactory {
    private static Logger logger = Logger.getLogger(HibernateSessionFactory.class);

    private static HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();

    public static HibernateSessionFactory getHibernateSessionFactory() {
        return hibernateSessionFactory;
    }

    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    private static void setSessionFactory() throws ExceptionInInitializerError {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            logger.info("Hibernate Configuration loaded. SessionFactory is build");
        } catch (ExceptionInInitializerError ex) {
            logger.info("Hibernate Configuration error", ex);
            throw new ExceptionInInitializerError();


        }

    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            setSessionFactory();
        }
        return sessionFactory;
    }
}
