package it.lanadantas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordinirestcontroller")
public class OrdiniRestController {
	@Autowired
	private ApplicationContext myContext;
	
	List<Ordine> ordini = new ArrayList<>();
			
	@GetMapping("/getallordini")
	public CreaOrdini getOrdini() {	
		CreaOrdini myOrdini = myContext.getBean(CreaOrdini.class);
		System.out.println(myOrdini);
		return myOrdini;		
	}
	
	@PostMapping("/addordine")
	public List<Ordine> addOrdine(@RequestBody Ordine ordine) {	
		ordini.add(ordine);
		return ordini;		
	}
	
	@DeleteMapping("deleteordine/{myString}")
	public List<Ordine> deleteOrdine(@PathVariable int idOrdine) {		
		ordini.removeIf(myOrdini -> myOrdini.getIdOrdine() == (idOrdine));		
		return ordini;
	}
	
}
