package com.keylesson.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.keylesson.hibernate.HibernateUtil;
import com.keylesson.persistence.User;

public class UserDAO {

	public String createUser(String name, Integer age,Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User user = new User();
			user.setName(name);
			user.setAge(age);
			user.setId(id);
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating User :" + e.getMessage());
			session.getTransaction().rollback();
			return "failure" ;
		}
		return "success";
	}
	
	public String createdeleteUser(Integer id) {
		Session session = null;
	      Transaction transaction = null;
	  
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.getTransaction();
	         transaction.begin();

	         //Delete a persistent object
	        /* User customer1=(User) session.get(User.class, 1L);
	         if(customer1!=null){
	            session.delete(customer1);
	            System.out.println("Customer 1 is deleted");
	         }*/
	         
	         //Delete a transient  object
	         User customer2=new User();
	         customer2.setId(id);
	         session.delete(customer2);
	         System.out.println("Customer 2 is deleted");
	         
	         transaction.commit();			
		} catch (Exception e) {
			System.err.println("Error creating User :" + e.getMessage());
			//session.getTransaction().rollback();
			return "failure" ;
		}
		return "success";
		
	}
	
	public String createupdateUser(String name, Integer age,Integer id) {
		Session session = null;
	    Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			User user = new User(name,age,id);
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			session.close();
	         
			
		} catch (Exception e) {
			System.err.println("Error creating User :" + e.getMessage());
			session.getTransaction().rollback();
			return "failure" ;
		}
		return "success";
		
	}
	
	

	public List getUsers(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List users = null;
		try {
			session.beginTransaction();
			users = session
					.createQuery("from User where name like :name")
					.setParameter("name", "%" + name + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}
		return users;
	}
}