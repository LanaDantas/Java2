package it.lanadantas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CLR_Ordine implements CommandLineRunner  {

	@Override
	public void run(String... args) throws Exception {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(Config.class);

		
		CreaOrdini ordineCreato = myContext.getBean(CreaOrdini.class);
		
		ordineCreato.stampaOrdini();
		
		myContext.close();

		
	}

}
