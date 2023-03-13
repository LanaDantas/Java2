package it.lanadantas;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
public class MenuRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(Config.class);

		System.out.println("----------------------------------------------");
		System.out.println("--------------- Menu ---------------");	

		
		Menu myMenu = myContext.getBean(Menu.class);
		
		myMenu.stampaMenu();

		myContext.close();
	}
}
