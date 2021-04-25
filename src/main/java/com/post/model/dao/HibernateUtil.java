package com.post.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration=new Configuration();
            configuration.configure();

            return configuration.buildSessionFactory();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error in Build SessionFactory.");
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

    public static void main(String[] args) {

    }
}
