package com.deep.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.deep.entity.Student;
import com.deep.utils.HibernateUtil;



public class InsertData {
	
	public static void main(String[] args) {
		
		SessionFactory sesFac=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(sesFac;ses) {
			
			Student student=new Student();
			student.setId(2);student.setMarks(75.1);
			student.setName("Deep Bhai");
			tx=ses.beginTransaction();
			ses.persist(student);
			tx.commit();
			System.out.println("Record Inserted");
			
		}catch(HibernateException he) {
			
			System.out.println("Hibernate Exception");
			he.printStackTrace();
			
		}catch(Exception e) {
		
			System.out.println("Exception");
			e.printStackTrace();
		}
	}
}
