package com.intellisoft.autopartsstore.runner.main;

import com.intellisoft.autopartsstore.entity.*;
import com.intellisoft.autopartsstore.hibernateconfig.hibernateutil.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

/**
 * Created by Сирожа и Маха on 30.07.2017.
 */
public class RunnApp {
    public static void main(String[] args){
        System.out.println("go");
        SessionFactory sessionFactory= HibernateSessionFactory.getHibernateSessionFactory().getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        CarMake carMake=new CarMake();
        carMake.setName("AVTOVAZZZ");
        session.saveOrUpdate(carMake);

        CarModel carModel=new CarModel();
        carModel.setModel("A4B5");
        carModel.setCarMake(carMake);
        session.saveOrUpdate(carModel);

        UserRole userRole=new UserRole();
        userRole.setName("Zakazchik");
        session.saveOrUpdate(userRole);

        User user=new User();
        user.setFirstName("ANDJEY");
        user.setUniqueKey("sdfsdf234234");
        user.setUserRole(userRole);
        session.saveOrUpdate(user);



        AutopartBrand autopartBrand=new AutopartBrand();
        autopartBrand.setName("Limforder");
        session.saveOrUpdate(autopartBrand);

        AutopartCategories autopartCategories=new AutopartCategories();
        autopartCategories.setName("diski tormoznie");
        session.saveOrUpdate(autopartCategories);

        Autopart autopart=new Autopart();
        autopart.setName("Disc tormoznoy");
        autopart.setPartNumber("123123asdad");
        autopart.setAutopartBrand(autopartBrand);
        autopart.setAutopartCategories(autopartCategories);
        autopart.setCarModel(carModel);
        session.saveOrUpdate(autopart);

        Order order=new Order();
        order.setNumber(999999999);
        order.setUser(user);
        ArrayList<Autopart>autoparts=new ArrayList<Autopart>();
        autoparts.add(autopart);
        order.setAutoparts(autoparts);
        session.saveOrUpdate(order);









        session.saveOrUpdate(order);
        transaction.commit();
        session.close();

    }
}
