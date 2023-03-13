package it.lanadantas.MySpringREST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myeventorestcontroller")
public class EventoController {

	private static ArrayList<Evento> eventi = new ArrayList<>();


	@PostMapping("/addevento")
	public Evento addEvento(@RequestBody Evento evento) {	
		eventi.add(evento);
		return evento;		
	}

	
	@GetMapping("/getalleventi")
	public List<Evento> getAllEventi() {			
		return eventi;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@DeleteMapping("deleteeventobyid/{id_evento}")
	public List<Evento> deleteClassByMyString(@PathVariable int id_evento) {
		// funzione lambda
		eventi.removeIf(myEvento -> myEvento.getId_evento() == id_evento);		
		return eventi;
	}
		
}
