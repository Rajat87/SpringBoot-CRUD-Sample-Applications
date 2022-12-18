package com.hibernate.scratch;



import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

public class App {

	public static void main(String[] args) {
		// Now I have all the three classes that I want to work with 
		// First I want to store the Student Object in the DB with the table name - Student
		// It should have the following columns
		// Student_id which should be the primary key, FirstName, MiddleName and Last name which are taken from the Embeddable class name
		// Then is should have  a age
		// Then it should have a foreign key with the Laptop_id which implies that a Student has a laptop.
		
		// Now the real work starts
		
		Configuration configuration = 
				new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(TennisPlayer.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		//Transaction transaction = session.beginTransaction();
		/*Name name = new Name("Rajat", "NA", "Pandey");
		Laptop laptop1 = new Laptop("101","Acer",null);
		Laptop laptop2 = new Laptop("102","Dell",null); 
		List<Laptop> laptops = List.of(laptop1,laptop2);
		Student student = new Student("1", name, 25, laptops);  // How can I map the student id in the laptop table without doing what I am doing
		laptop1.setStudent(student);
		laptop2.setStudent(student);
		session.persist(laptop1);
		session.persist(laptop2);
		session.persist(student); // The order doesn't matter
		*/
		//Student student = session.get(Student.class, "1");  // This will give me a single record which implies single object
		//System.out.println(student);
		//System.out.println(student.getName());
		/*TennisPlayer tennisPlayer1 = new TennisPlayer(1,"Novak Djokovic", 20);
		TennisPlayer tennisPlayer2 = new TennisPlayer(2,"Roger Federer", 20);
		TennisPlayer tennisPlayer3 = new TennisPlayer(3,"Rafael Nadal", 22);
		TennisPlayer tennisPlayer4 = new TennisPlayer(4,"Andy Murray", 3);
		TennisPlayer tennisPlayer5 = new TennisPlayer(5,"Stan Wawrinka", 2);
		*/
		
		
		
//		List<TennisPlayer> list = List.of(tennisPlayer1,tennisPlayer2,tennisPlayer3,tennisPlayer4,tennisPlayer5);
//		for(TennisPlayer player : list) {
//			System.out.println(player.getClass());
//			session.persist(player);
//		}
		
		// For all columns
		/*Query query = session.createQuery("from TennisPlayer where grandSlams>10");
		List<TennisPlayer> players= (List<TennisPlayer>) query.getResultList();
		//System.out.println(players);
		players.stream().forEach(player -> System.out.println(player));
		*/
		// For a Single result
		/*Query query = session.createQuery("from TennisPlayer where grandSlams>=20");
		System.out.println(query.getSingleResult().getClass());// We get a Tennis player object which is inside a Object object
		//Object o =query.getSingleResult();  // This is a polymorphic statement 
		TennisPlayer player = (TennisPlayer)query.getSingleResult();
		System.out.println(player);
		
		
		
		// We will have to persist all the tables which we want to store the tables in the DB.
		// So we will have to execute the persist method multiple times.
		
		//transaction.commit();
		// In HQL we always get the required type of object but in the case of SQLQuery we get an object of type object. So we have to explicitly
		// specify that we want the object of this class
		
		//SQLQuery<TennisPlayer> sqlQuery = session.createSQLQuery(""); // This is deprecated
		NativeQuery<TennisPlayer> nativeQuery = session.createNativeQuery("Select * from TennisPlayers",TennisPlayer.class);
		//nativeQuery.addEntity(TennisPlayer.class);
		List<TennisPlayer> tennisPlayers = nativeQuery.getResultList();
		// I can Iterate through it now
		*/
		session.beginTransaction();
		
		/*Name name = new Name("Shivam", "NA", "Kapoor");
		Name name2 = new Name("Suhas", "Balasaheb", "Shikare");
		
		Laptop laptop1 = new Laptop("103", "Lenovo", null);
		Laptop laptop2 = new Laptop("104", "Asus", null);
		Laptop laptop3 = new Laptop("105", "Razer", null);
		Laptop laptop4 = new Laptop("106", "Alienware", null);
		Laptop laptop5 = new Laptop("107", "HP", null);
		Laptop laptop6 = new Laptop("108", "Apple", null);
		
		List<Laptop> laptops1 = Arrays.asList(laptop1,laptop2,laptop3);
		List<Laptop> laptops2= Arrays.asList(laptop4,laptop5,laptop6);

		Student student1 = new Student("102", name, 26, laptops1);
		Student student2 = new Student("103", name2, 29, laptops2);
		laptop1.setStudent(student1);
		laptop2.setStudent(student1);
		laptop3.setStudent(student1);
		laptop4.setStudent(student2);
		laptop5.setStudent(student2);
		laptop6.setStudent(student2);
		
		session.save(student1);
		session.save(student2);
		session.save(laptop1);
		session.save(laptop2);
		session.save(laptop3);
		session.save(laptop4);
		session.save(laptop5);
		session.save(laptop6);
		*/
		
		// Now I want to retrieve only the brand of the laptops using HQL
		Query query = session.createQuery
				("Select l.Brand, s.name from Laptop as l inner join l.student as s");
		// Now when I write this query what am I gonna get
		//Every column will be represented as an object and each row will be an array of objects. And all the arrays will be present in the List
		// of type object
		
		
		// Join using HQL
		List<Object[]> list = (List<Object[]>)query.getResultList();
		System.out.println(list.size());
		for(Object[] o : list) {
			System.out.println(o[0]+"   "+o[1]);
		}
		// Dekh common sense hai tu student ki details kaise nikal sakta hai jab tu laptop object use kr rha hai.
		// TO jab tu wo krne k try krega to error ayega hi 
		// To tujhe join use krna padega
		// Same query with SQL Query
		NativeQuery nativeQuery = session.createNativeQuery("Select l.brand, s.firstname, s.lastname, s.middlename from laptop l inner join student s on l.student_student_id = s.student_id order By firstname;");
		List<Object[]> list2 = nativeQuery.getResultList();
		for(Object[] o : list2) {
			System.out.println(o[0]+"   "+o[1]); // 
		}
		
		
		
		Criteria criteria = session.createCriteria(Student.class);
		
		criteria.add(Restrictions.eq("name", "Rajat"));
		System.out.println(criteria.list());
		session.getTransaction().commit();
		

	}

}
