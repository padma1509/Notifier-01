package com.example.demo.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.demo.model.NoteBook;
import com.example.demo.model.User;

public class NoteBookDAO {
	
	
	public void createNoteBook(NoteBook notebook) {
		Session session = HibernateUtil.getFactory().openSession();
		try
		{
		 session.beginTransaction();
		 session.save(notebook);
		 session.getTransaction().commit();
		}catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	
	
	public void updateNoteBook(Integer id, String notebookName,String notebookDescription) {
		
		
		Session session = HibernateUtil.getFactory().openSession();
		try
		{
			
		 session.beginTransaction();
		 NoteBook noteBook = (NoteBook) session.get(NoteBook.class, id);
		 noteBook.setNoteBookName(notebookName);
		 noteBook.setNoteBookDescription(notebookDescription);
		 session.update(noteBook);
		 session.getTransaction().commit();
		 
		}catch (HibernateException e) {
			
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace(); 
	         
	      } finally {
	         session.close(); 
	      }
		
	}
	
	
	public List<NoteBook> listOfNoteBook(User user) {
		Session session = HibernateUtil.getFactory().openSession();
		 List<NoteBook> list=null;
		try
		{
		 session.beginTransaction();
		 Criteria criteria=session.createCriteria(NoteBook.class);
		 criteria.add(Restrictions.eq("user", user));
		  list = criteria.list();
		  
		}catch (HibernateException e) {
			
	         e.printStackTrace(); 
	         
	      } finally {
	         session.close(); 
	      }
		
		return list;	
	}
	
	
	public void deleteNoteBook(NoteBook noteBook) {
		Session session = HibernateUtil.getFactory().openSession();
		
		try {
			session.beginTransaction();
			session.delete(noteBook);	
			session.getTransaction().commit();
		}catch (HibernateException e) {
   
	         e.printStackTrace(); 
	         
	      } finally {
	         session.close(); 
	      }
		
	}
	
	
	public NoteBook getNoteBookObject(Integer id) {
		Session session = HibernateUtil.getFactory().openSession();
		try
		{
		 session.beginTransaction();
		 Criteria criteria=session.createCriteria(NoteBook.class);
		 criteria.add(Restrictions.eq("id", id));
		 return (NoteBook) criteria.uniqueResult();

		}catch (HibernateException e) {
			
	         e.printStackTrace(); 
	         
	      } finally {
	         session.close(); 
	      }
		return null;
		
		
		
	}

	public int add(int a,int b)
	{
		return a+b;
	}
	
	
	

}
