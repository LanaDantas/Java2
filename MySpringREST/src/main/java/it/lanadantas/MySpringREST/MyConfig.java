package it.lanadantas.MySpringREST;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
    MyClass myClass() {
        return new MyClass();
    }
	
	@Bean
	Evento myEvento() {
        return new Evento();
    }

}
