package com.rajat.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Hibernate!" );
        
        // Now I want to persist this object in pgadmin without using JDBC which involves using SQL
        /*
         * Our Ultimate aim is to save it in DB but simply calling a save method, pass the object and boom it gets saved
         * Something like this
         * save(alien)
         * This special save method belongs to an Interface known as Session
         * This session interface is part of the Hibernate framework
         * There are 3 steps to get the object of Session or the class which is implementing the Session class
         * 1) First, create the object of the configuration class
         * 2) Then we have to get the object of the SessionFactory interface. We use a method of the configuration class to get the object of it.
         * 3) Finally, we can get the object of Session using the session factory object obtained in the previous point.
         * Lastly we need to annotate the class as entity in order to save it in the DB.
         * Another Key point every table in hibernate should have a primary key. For this we use an annotation named as @Id before the ins. variable which you want to set as PK.
         * After this we need to use a transaction to commit which will actually do the work.
         * To get the object of Transaction we use the method of session object.
         * Finally in order to create the Table we need to add a new property in the XML.
         * <property name="hbm2ddl.auto">update</property>. This property is the key here. For. e.g if we use the update value then first it will check whether the tables is present in the DB or not.
         * If no, then it will create the table and insert the row. If yes then it will simply insert.
         * However if we use the create value then it will create a new table everytime by dropping the old table.
         * These many steps will help you to create the table in the DB and insert the Obj in the table.
         */
        
        /*Deprecation
         * Now some changes which are required in the above steps:
         * Firstly the save method is deprecated since Hibernate 6
         * So, we need to use the persist() method instead.
         * The method buildSessionFactory is deprecated from the hibernate 4 release and it is replaced with the new API. If you are using the hibernate 4.3.0 and above, your code has to be:

			Configuration configuration = new Configuration().configure();

			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

			SessionFactory factory = configuration.buildSessionFactory(builder.build());
         */
        
        /*Annotations
         * The first Annotation is @Entity(name = ""). This will choose the table name passed in the name parameter irrespective of the class.
         * We can also use @Table(name = ) to choose the table name.
         * There is a difference in both which will be discussed in HQL.
         * We can also use @Column(name = ) to have different column name than as mentioned in the attribute.
         * If we want a column not to be saved in DB then we can mark it as @Transient. Then that column will not be persisted. The column itself will not be created.
         * 
         */
        
        /*Fetching Data
         * To fetch data we need to use a method named as session.get(the class name, the primary key value)
        
        /*Embeddable
         * If you want to create a class for an attribute then this comes into play.
         * For e.g. in this case a Alien has a name. But, It can be a combination of 3 things F.name, L.name and M.name
         * So, in that case we can create a seperate class for it and use Embeddable. 
         * Embeddable will convert the attributes of the other class into columns of table in the same table
         * 
         */
        
        
        /*Relation Mapping  - One to One, One to Many, Many to Many or Many to One
         * ONE TO ONE:
         * For e.g  - If only one student can have only one laptop the we need to use @OnetoOne annotation
         * What we can do is we can create a student will have a laptop relationship. For that we create a reference of laptop in student.
         * We mark the reference with a @OnetoOne annotation which will ensure that one student will have only one laptop.
         * On DB level, The student table will have the primary key of the laptop table as it's foreign key.
         * 
         * ONE TO MANY:
         * If a student can have multiple laptops then we need to use the @OnetoMany annotation to create a one to many relationship.
         * A student can have a list of laptops and it needs to be marked with the @OnetoMany annotation.
         * This will create a third table without a PK which will hold the primary Key's of both the tables as columns.
         * Now there will be no foreign key in the Students table.
         * 
         * MANY TO ONE:
         * Now, it is common sense that as we have created a One to many relationship between student and laptop,
         * We also need to create a relationship that many laptops can belong to one student.
         * Thus we need to create a reference of the student as the instance variable in the Laptop class.
         * Then we need to mark it with the @Many to One annotation.
         * 
         * -------------Key Point------------
         * When we mark the relationship in both the classes what it does is it creates a foreign key in the Laptop table, but will not create the FK in the Student table.
         * Instead it will still create a third table without a PK which will hold the primary Key's of both the tables as columns.
         * To prevent this what we can do is use @OneToMany(mappedBy = "student"). This will create the FK in the table which holds the reference student, without creating a third table.
         * 
         * MANY TO MANY
         * In the many to many relationship we will always need a third table in order for it to work.
         * We use the annotation @ManyToMany to specify the relation
         * 
         * 
         * FETCH EAGER LAZY
         * LAZY - When we use the get method to get the object from the DB by default id does not fetch any collection
         * It only fetches it when we actually try to access it or use it. This is called Lazy
         * EAGER - This is where eager comes into the picture. If we mark the @OnetoMany annotation as Eager then it will automatically retreive it.
         * e.g- @ManyToMany(mappedBy = "student",fetch = FetchType.EAGER)
         * 
         * 
         * CACHING - Important
         * When we request data from the server using the get method what hapeens is that the request hits the server for retreiving it.
         * But, what happens when we make the same request again. Will it re-execute and hit the DB again which is not great for performance.
         * This is where caching comes into play, It ensures that when the user types the same query in the DB it does not hit the server again.
         * FIRST LEVEL CACHING - In first level caching hibernate ensures that if the same request is being made then there is no need to fire another select uery.
         * It stores the result in the cache memory and does not hit the DB server. But, the limitation is that it stores it only for a single session.
         * So, when we create another session object and make the same request again. It will still generate the query and hit the DB.
         * SECON LEVEL CACHING - This is where SLC comes into play
         * 
         */
        
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        //session.save(alien); // Deprecated
       // session.persist(alien);
//        Alien fetchedAlien = session.get(Alien.class, 0);
//        System.out.println(fetchedAlien);
        Laptop laptop = new Laptop();
        List<Laptop> laptops = new ArrayList<Laptop>();
        laptops.add(laptop);
        Student student = new Student(1, "Rajat", 50, laptops);
        List<Student> students = new ArrayList<Student>();
        students.add(student);
        laptop=new Laptop(0, null, "Lenovo"); 
        //session.persist(laptop);
        //session.persist(student);
        Name name = new Name("Mr", "Rajat", "Pandey");
        Laptop laptopAlien = new Laptop();
        List<Laptop> laptopsAlien = new ArrayList<Laptop>();
        laptopsAlien.add(laptopAlien);
        Alien alien =new Alien(0, name, "Blue", laptopsAlien);
        laptopAlien = new Laptop(1, alien, "Dell");
        //session.persist(laptopAlien);
        //session.persist(alien);
        // Fetching the alien
        
        Alien alienFetch=session.get(Alien.class, 0);
        
        //System.out.println(session.get(Alien.class, 0).getClass());
        System.out.println(alienFetch);
        // There is a issue here if I have overriden toString() method in both the classes and try to print the object then I get a stack overflow Exception
        // This can be resolved by removing one of the override toString methods.
        
        transaction.commit();
        
        
               
    }
}
