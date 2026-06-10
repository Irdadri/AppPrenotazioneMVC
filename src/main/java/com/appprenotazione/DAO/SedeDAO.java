package com.appprenotazione.DAO;

import com.appprenotazione.model.Sede;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SedeDAO {
    public List<Sede> getAllSedi(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Sede> listaSedi = session.createQuery("from Sede ").list();
        session.close();
        return listaSedi;
    }
}
