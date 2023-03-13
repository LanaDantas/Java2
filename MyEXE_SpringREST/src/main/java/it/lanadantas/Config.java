package it.lanadantas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(enforceUniqueMethods=false)
public class Config {
    
    @Bean
    Birra myBirra() {
        return new Birra();
    }
    
    @Bean
    HamburgerSemplice myHamburgerSemplice() {
        return new HamburgerSemplice();
    }
    
    @Bean
    Cheeseburger myCheeseburger() {
		return new Cheeseburger();
    }
    
    @Bean
    Chickenburger myChickenburger() {
        return new Chickenburger();
    }
    
    @Bean("myMenu")
    Menu myMenu() {
        Menu menu = new Menu();
        menu.consumazioni.add(myBirra());
        menu.consumazioni.add(myHamburgerSemplice());
        menu.consumazioni.add(myCheeseburger());
        menu.consumazioni.add(myChickenburger());
        
        return menu;
    }
    
    @Bean
    Ordine myOrdine() {
        return new Ordine();
    }
    
    @Bean
    Cliente myCliente() {
        return new Cliente();
    }
    
    @Bean
    CreaOrdini creaOrdini() {
		Cliente cliente1 = new Cliente(1, "Sara", "S111");
    	List<Consumazione> consumazioni = new ArrayList<>();
    	consumazioni.add(myBirra());
    	consumazioni.add(myChickenburger());
    	CreaOrdini ordineCreato = new CreaOrdini();
    	Ordine ordine1 = new Ordine (1, cliente1, consumazioni);
    	ordineCreato.addOrdine(ordine1);
        return ordineCreato;
    }
    
}
