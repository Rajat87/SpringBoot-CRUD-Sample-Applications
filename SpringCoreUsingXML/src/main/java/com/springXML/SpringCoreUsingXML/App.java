package com.springXML.SpringCoreUsingXML;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	/*BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));// To get the object of Bean Factory
    	Alien alien = (Alien)beanFactory.getBean("alien"); // This "alien" will be the id attribute in the bean tag
    	System.out.println(alien);
    	alien.code();
    	*/
    	
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    	Alien alien = (Alien)applicationContext.getBean("alien");
    	System.out.println(alien);
    	alien.code();
    	// One thing as we are using the classPath obj we have to move the configuration file to the main package
    }
    
}
