package com.intellisoft.library.hibernate.util.sessionfactory;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


/**
 * Created by Сирожа и Маха on 27.07.2017.
 */
public class SessionFactorySingleTone {
    private static Logger logger=Logger.getLogger(SessionFactorySingleTone.class);
    private static SessionFactorySingleTone sessionFactorySingleTone = new SessionFactorySingleTone();
    private static SessionFactory sessionFactory;

    public static SessionFactorySingleTone getSessionFactorySingleTone() {
        return sessionFactorySingleTone;
    }

    private SessionFactorySingleTone() {
    }
    private static void setSessionFactory() throws HibernateException{
        if(sessionFactory==null){
            sessionFactory= new Configuration().configure().buildSessionFactory();
            logger.info("Hibernate configuration loaded. SessionFactory is received");
            System.out.println("Hibernate configuration loading is successful");

        }
           }

    public static SessionFactory getSessionFactory(){
        setSessionFactory();
        return sessionFactory;
         }


}
