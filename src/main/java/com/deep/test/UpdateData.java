package com.deep.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.deep.entity.Student;
import com.deep.utils.HibernateUtil;

public class UpdateData {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session ses = HibernateUtil.getSession();
		Transaction tx = null;

		try (sessionFactory; ses) {
			Student student = new Student();
			student.setId(1);
			student.setName("Hati Bhai");
			student.setMarks(110.9);
			tx=ses.beginTransaction();
			ses.update(student);
			tx.commit();

		} catch (HibernateException he) {
			
			System.out.println("Hibernate Exception");
		} catch (Exception e) {
			
			System.out.println("Exception");
		}
	}
}
