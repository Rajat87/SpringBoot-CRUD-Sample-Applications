package com.rajat.HibernateCachingAndHQL;

import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class Main {

	public static void main(String[] args) {
		/*CACHING - Important
        * When we request data from the server using the get method what happens is that the request hits the server for retreiving it.
        * But, what happens when we make the same request again. Will it re-execute and hit the DB again which is not great for performance.
        * This is where caching comes into play, It ensures that when the user types the same query in the DB it does not hit the server again.
        * THe process flow is that whenever we try to fetch using the get method, hibernate first checks the First level cache if ot found then it checks the second level cache
        * and if not found then it fires the query to the DB.
        * FIRST LEVEL CACHING - In first level caching hibernate ensures that if the same request is being made then there is no need to fire another select uery.
        * It stores the result in the cache memory and does not hit the DB server. But, the limitation is that it stores it only for a single session.
        * This is present by default and there is no need to implement it.
        * So, when we create another session object and make the same request again. It will still generate the query and hit the DB.
        * SECOND LEVEL CACHING - This is where SLC comes into play. When we implement it then we can use Second level caching.
        * But there are certain steps to do it which are mentioned below :
        * 1) First we need to download the jar files or add the dependency in maven of ehcache and hibernate - ehcache
        * 2) Once, that is done we have to specify 2 property tags in the hibernate configuration file. 
        * <property name="hibernate.cache.use_second_level_cache">True</property> - This sets the caching to be Second level
        * <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>:
        * This specifies the path of the class which will integrate the ehcache
        * 3) Then we have to mark the entity class with 2 annotations - 
        * First is @Cacheable
        * Second is Cache which specifies the different strategies. For e.g. - Read, Read/write
        * @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
        * Another key point is that Second level caching is by default applicable for only get method
		*/
		
		
		/*Hibernate Object States | Persistence Life Cycle
		 * There are 3 states in hibernate:
		 * 1) Transient
		 * 2) Persistent
		 * 3) Detached
		 * 4) Removed
		 * This is applicable when we create a new object and persist it.
		 * Transient State - Whenever we create an Obj of the Bean it is by default in the transient state. Transient means the state of the object is in RAM and the moment we close the application we will lose it
		 * Persistent State - The moment we execute the persist method the obj goes in the persistent state. Now whatever you do with the obj will be reflected in the DB.
		 * For e.g when we create the obj and execute the persist method, Now the obj is stored in the DB. But after that we make changes in the obj it is still reflected in the DB.
		 * This is because even after executing the persist method the object is still in the persistent state.
		 * Detached state - Now what if you want to change the state of an object but do not want it to be reflected in DB. Before doing that we have to make sure that either you commit the transaction or close the session or you have to detach the object from the session.
		 * For that we have to use the detach method.
		 * Removed State - When we remove the data from the data using either the remove or delete method it goes into the removed state. It means that the object is present in java but not in the DB.
		 *  
		 *  This is applied when we get a new object:
		 *  When we fetch the object using get or find method it is by default in persistent state. That means if you make any changes to the obj it will get reflected in the DB.
		 *  
		 */
		
		
		/*GET VS LOAD
		 * The main difference is performance.
		 * GET - When you try to fetch the object using the get method it will always fire the query even if you don't use the object. So, everytime it will hit the DB. That menas it will give you the object.
		 * LOAD - What Load does it will not fire or generate the query until you try to use the object. Load will give you the proxy object. 
		 * 
		 */
		
		/*HQL - Hibernate Query Language
		 * For advanced retrievals we need something known as HQL
		 * E.G. - Select rollNo from Student;
		 * In HQL - rollNo is an attribute or property and Student is a Class. In SQL rollNo is a column and Student is a Table.
		 * In SQL if we need to fetch all records we use - Select * from Student;
		 * But in HQL we simply write - from Student;
		 * In HQL when we run a query we get a List of Objects. The List will contain each record of the table in the form of an object.
		 * We can also use SQL which is done using Native SQL.
		 * 
		 * To create a query object we use the method session.createQuery()
		 * Query query = session.createQuery("from Alien"); //To fetch all the rows.
         * List<Alien> aliens =query.getResultList()   // This will always fetch multiple results
		 * To fetch a single query we use the method query.getSingleResult().
		 * 
		 * KEY POINT :
		 * Now if we specify particular columns with a where clause then we will not get a List of objects.
		 * Instead, We will get an Array of type Object.
		 * For this we do something like this - Object [] objects = (Object [])query.getSingleResult();
		 * But if we do not specify the where clause then we will be getting a List of Array of type Object. 
		 * We do something like this - List<Object[]> aliens = (List<Object[]>)query.getResultList();
		 * Also as is the case with SQL we should use alias for better readability
		 * The most important point is that whenever you specify columns hibernate will treat the fetched Object as type object doesn't matter how many columns you fetch.
		 */
		
		/*SQL IN HIBERNATE
		 * The first difference is that instead of creating a query obj you have to create a SQLQuery object.
		 * 
		 */
		
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession(); 
        Transaction transaction = session.beginTransaction();
        
//        for(int i=1; i<=50;i++) {
//        	Student student = new Student(i,"Student"+i,"Green");
//        	session.persist(student);
//        }
        /*
        // Caching Demonstration
        System.out.println("--------Session1--------");
        Student student = session.get(Student.class,1);
        System.out.println(student);
        Student student2 = session.get(Student.class,1);
        System.out.println(student2);
        transaction.commit();
        session.close();
        
        System.out.println("--------Session2--------");
        Session session2 = factory.openSession();
        Transaction transaction2 =session2.beginTransaction();
        Student sRef=session2.get(Student.class,1);
        System.out.println(sRef);
        
        
        // Persistence Life cycle demonstration
        Student student3 = new Student();  // This is by default in new state
        student3.setRollNo(100);
        student3.setName("Carlos");
        student3.setColor("Green");// The moment we initialize the object it goes into transient state.
        session2.persist(student3);// It now goes into persistent state
        session2.remove(student3);// Now the object is in removed state.
        transaction2.commit();
        session2.detach(student3);
        student3.setName("Andrew");// It is still in persistent state now even if you don't call the persist method again still this change will get reflected in DB. It will fire the update query.
        //Now what if we don't want this name change to be reflected in DB. For this we need to call the detach method before the change. Now this name change will not be saved in DB. But the key point is that detach needs to be executed after the commit method.
        // Another thing, After commit the object will by default be in detach state.
         */
        //HQL Part
//        Random random = new Random();
//        for(int i=0;i<=50;i++) {
//        	Alien alien = new Alien(i, "Alien "+i, random.nextInt(100));
//        	session.persist(alien);
//        }
        /* FOR FETCHING ALL THE ROWS
        Query query = session.createQuery("from Alien"); //To fetch all the rows.
        List<Alien> aliens =query.getResultList();  // We will get a Array List
        for(Alien alien : aliens) {
        	System.out.println(alien);
        }
        */
        
        /*FOR FETCHING A SINGLE RECORD USING A WHERE CLAUSE
        Query query = session.createQuery("from Alien where rollNo=7");
        Alien singleAlien = (Alien)query.getSingleResult();
        System.out.println(singleAlien);
        */
        
        /* FOR FETCHING A SINGLE RECORD USING A WHERE CLAUSE BUT WITH COLUMNS SPECIFIED
        Query query = session.createQuery("Select rollNo, marks, name from Alien where rollNo=7"); // In this case we will get an Object array in which each index will contain a specified column when we use a where clause.
        Object [] objects = (Object [])query.getSingleResult(); // If we
        System.out.print("Roll No. - "+objects[0]+"| Marks - "+objects[1]+"| Name - "+objects[2]);
        */
        /* FOR FETCHING A LIST OF RECORDS USING A WHERE CLAUSE BUT WITH COLUMNS SPECIFIED
        Query query = session.createQuery("Select rollNo, marks, name from Alien");
        List<Object[]> aliens = (List<Object[]>)query.getResultList();
        for(Object [] alienArray : aliens) {
        	System.out.print("Roll No. - "+alienArray[0]+"| Marks - "+alienArray[1]+"| Name - "+alienArray[2]);
        	System.out.println();
        }
        */
        
        /*
        int b=50;
        // To pass dynamic values in the where clause we can do something like this
        
       // Query query = session.createQuery("Select max(marks) from Alien a where marks>"+b);
        //Or
        Query query = session.createQuery("Select max(marks) from Alien a where marks> :b");
        query.setParameter("b", b);
        Object object = query.getSingleResult();
        System.out.println(object);
        */
        
        //SQLQuery<Alien> sqlQuery = session.createSQLQuery("Select * from Alien");// Deprecated
        NativeQuery<Alien> nativeQuery = session.createSQLQuery("Select * from Alien");
        nativeQuery.addEntity(Alien.class); // After writing this we automatically get the list of type alien
        List<Alien> aliens =  nativeQuery.list();  // This always gives the result in the form of an object and typecasting is also not working here
        for(Alien alien : aliens) {
        	System.out.println(alien);
        }
        transaction.commit();
                                                                                                             
	}

}
