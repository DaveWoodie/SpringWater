
package serverrunner;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@EnableJpaRepositories
@ComponentScan("com.netbuilder")
@EnableAutoConfiguration
public class Application  {
	
	public static void main(String args[]) throws ServletException, LifecycleException {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		//listBeans(ctx);
	}
	
	
	//Lists all beans active in the application context
	//Use to view if a specific bean has been created
	public static void listBeans(ApplicationContext ctx)
	{
		String s;
		
		for(int i = 0; i < ctx.getBeanDefinitionCount(); i++)
		{
			s = (ctx.getBeanDefinitionNames()[i]);
			
			System.out.println("------> Bean " + (i + 1) + " : " + s);
		}
	}
}