package com.example.demo.DAO;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.example.demo.model.User;

public class UserDAO {
	
	
	
	public String createUser(User userObj) {
		
		Session session = HibernateUtil.getFactory().openSession();
		try
		{
			session.beginTransaction();
		 session.save(userObj);
		 session.getTransaction().commit();
		 return "success";

		} catch (JDBCException e){

			return String.valueOf(e.getSQLException().getErrorCode());
		}

		catch (HibernateException e) {
			if (session.getTransaction() != null) session.getTransaction().rollback();
			e.printStackTrace();
			return e.getMessage();
		} finally {
	         session.close(); 
	      }

		
	}
	
	public void updateUser(User user) {
		Session session = HibernateUtil.getFactory().openSession();
		try {
		session.beginTransaction();
		session.update(user);
		 session.getTransaction().commit();
		}catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}

	public  User  getUserObj(String email) {
		Session session = HibernateUtil.getFactory().openSession();
		User user=null;
		try
		{
		session.beginTransaction();
		Criteria criteria= session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		 
		 user=(User) criteria.uniqueResult();
		}catch (HibernateException e) {
	         //if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return user;
		
	}
	
	
	public User authUser(String email,String password)
	{
		User userObj=getUserObj(email);
		if(userObj!=null )
		{
			if(userObj.getPassword().equals(password))
				return userObj;			
		}
		
		return null;
	}


	public void testFun() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getFactory().openSession();
		 
        session.beginTransaction();
        
        
      		String userName="Monish";
      		String password="pass";
      		String email="monishwaran"; 
      		String mobileNumber="9952543961";
      		
      		
      		
      		User user=new User(userName,password,email,mobileNumber);
      	

       

        session.save(user);
       
     
        session.getTransaction().commit();

        Query q = session.createQuery("From User");
                
        List<User> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (User next : resultList) {
            System.out.println("next employee: " + next);
        }
		
	}

	

}
