package com.shengsiyuan.hibernate;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			sessionFactory = configuration.buildSessionFactory(registry);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*
		Student student = new Student();
		student.setName("zhangsan");
		
		IdCard idCard = new IdCard();
		idCard.setNumber(987654);
		
		student.setIdCard(idCard);
		idCard.setStudent(student);
		
		Team team = new Team();
		team.setName("team1");
		
		team.setStudents(new HashSet<Student>());
		team.getStudents().add(student);
		
		student.setTeam(team);
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			session.save(team);
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		*/
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
//			Team team = session.get(Team.class, "297e364c5405c1a6015405c1a9fb0000");
//			System.out.println(team.getName());
			
			Student student = session.get(Student.class, "297e364c5405c1a6015405c1aa120001");
			System.out.println(student.getName());
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		
		
		/*
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Student student = null;
		
		try {
			tx = session.beginTransaction();
			
			student = session.get(Student.class, "8a80869153fe17e00153fe17e2780000");
			student.setName("lisi");
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		System.out.println(student.getName());
		*/
		
		/*
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Student student = null;
		
		try {
			tx = session.beginTransaction();
			
			student = session.get(Student.class, "8a80869153fe17e00153fe17e2780000");
			session.delete(student);
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		*/
		
		sessionFactory.close();
	}
}
