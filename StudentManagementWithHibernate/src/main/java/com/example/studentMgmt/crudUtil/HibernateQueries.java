package com.example.studentMgmt.crudUtil;

import java.util.Arrays;
import java.util.List;

//import javax.persistence.Query;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.studentManagement.entity.Gender;
import com.example.studentManagement.entity.Student;
import com.example.util.HibernateUtil;

public class HibernateQueries {
		
	// List all students from the "Student" table
	public static boolean listStudents () {		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			//execute an HQL query to retrieve all students
			Query<Student> query = session.createQuery(" from Student");  			
			List<Student> empList = query.list();
			for(Student std : empList){
				System.out.println(std);
			}
			System.out.println ("Student Listed Successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println ("Error Found");
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
			
	}
	
	// Count the number of students in the "Student" table
	public static boolean   countStudents () {		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			//HQL query to count the number of students
			Query  query =session.createQuery("select count(id) from Student");  			
			long  sumSalary = (Long) query.uniqueResult();
			System.out.println ("Number of Students = " + sumSalary) ;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println ("Error Found");
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
			
	}

	// Retrieve and print information for a single student with a specific ID
	public static boolean  printSingleStudent() {		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			
			Query query = session.createQuery("from Student where id= :id");
			query.setParameter("id", 3);
			Student std = (Student) query.uniqueResult();
			System.out.println("Single Student retrived is \n" + std);
			 
			System.out.println ("Single Student Fetched Successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println ("Error Found");
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
			
	}
	
	// Update a student's first name in the Student table
	public static boolean  updateStudent() {		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			//HQL Update Student
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("update Student set firstName= :name where id= :id");
			query.setParameter("name", "Pankaj");
			query.setParameter("id", 3);
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Student Update Status="+result);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println ("Error Found");
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
			
	}
	
	public static boolean  deleteStudent() {		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			Transaction tx = session.beginTransaction();
			//HQL Delete Student, we need to take care of foreign key constraints too
			Query query = session.createQuery("delete from Address where id= :id");
			query.setParameter("id", 4);
			int result = query.executeUpdate();
			System.out.println("Address Delete Status="+result);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println ("Error Found");
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
			
	}	
	
	public static void main(String[] args) {
//		listStudents () ;
//		countStudents ();
		//printSingleStudent();
		//updateStudent();
		//printSingleStudent();
		
		 listStudentsNames ();
	}
	
	// List student names along with course information from "Student" and "Enrollment" tables
	public static boolean   listStudentsNames () {		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// Join "Student" and "Enrollment" tables and retrieve student names and course information
			Query query =session.createQuery("select s.firstName,  s.lastName, e.course.title,  e.course.credit " +
				   " from Student s, Enrollment e where s.id = e.student.id");  						 
			List<Object[]> groupList = query.list();
			for(Object[] arr : groupList){
				System.out.println (arr[0]);
				System.out.println (arr[1]);
				System.out.println (arr[2]);
				System.out.println ("Credit " + arr[3]);
				System.out.println(Arrays.toString(arr));
			}
			System.out.println ("Student Listed Successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println ("Error Found");
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
			
	}
}
