
package com.example.demo.DAO;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    public static SessionFactory factory;
    public static SessionFactory getFactory(){
        if (factory==null) {
            factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return factory;

    }
    public void closeFactory(){

        if(factory.isOpen()){
            factory.close();
        }
    }

    public static void main(String[] args) {
        SessionFactory sf=HibernateUtil.getFactory();
        System.out.println(sf);
    }
}

