package app.rajat;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//BeanFactory bean =  new XmlBeanFactory(new FileSystemResource("spring.xml")); Deprecated way - This does not create the bean until the getBean method is called
    	ApplicationContext bean = new ClassPathXmlApplicationContext("spring.xml");
        Alien alien = bean.getBean("alien1",Alien.class);
        System.out.println(alien);
        //alien.code();
        
    }
}
