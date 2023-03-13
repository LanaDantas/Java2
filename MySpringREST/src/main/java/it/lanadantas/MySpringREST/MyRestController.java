package it.lanadantas.MySpringREST;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myrestcontroller")
public class MyRestController {
	
	// ArrayList
	private static ArrayList<MyClass> myClasses = new ArrayList<>();
		
	@Autowired
	private ApplicationContext myContext;
			
	/* GET */	
	// GetMapping associa un metodo del controller a un’operazione HTTP GET per il path specificato
	@GetMapping("/myget")	
	public String myGet() {
		return "REST Get";
	}

	@GetMapping("/mygetquerystring")
	// RequestParam accetta querystring
	//mygetquerystring?myparameter1=Aldo&myparameter2=33
	public String myGetQuerystring(@RequestParam String myparameter1, int myparameter2) {
		return "Get con querystring: " + myparameter1 + " - " + myparameter2 * 2;
	}
	
	@GetMapping("/mygetpathvariables/{mypathvariable1}/{mypathvariable2}")
	//mygetpathvariables/Aldo/33
	public String myGetParameters(@PathVariable String mypathvariable1, @PathVariable String mypathvariable2) {
		int mypathvariable2int = Integer.parseInt(mypathvariable2);
		return "Get con variabli: " + mypathvariable1 + " - " + mypathvariable2int * 2;
	}
	
	// La response di oggetti Java/Bean viene automaticamente convertita in JSON 
	// anche senza indicare esplicitamente MediaType JSON
	//@GetMapping(value = "/mygetclass", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/mygetclass")
	public MyClass myGetClass() {
		MyClass myClass = myContext.getBean(MyClass.class);			
		return myClass;
	}
		
	/* POST */	
	// Ottiene i dati da semplici stringhe (@RequestParam)
	@PostMapping("/mypostparams")	
	public String myPostParams(@RequestParam String myparameter1, String myparameter2) {
		int myparameter2int = Integer.parseInt(myparameter2);
		return "Post con parametri: " + myparameter1 + " - " + myparameter2int * 2;
	}
		
	// Ottiene i dati da oggetto JSON (@RequestBody) 
	// anche senza indicare esplicitamente i MediaType JSON
	//@PostMapping(value = "/mypostobj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/mypostobj")
	public MyClass myPostObj(@RequestBody MyClass myClass) {	
		myClasses.add(myClass);
		return myClass;		
	}
		
	// Ritorna la lista delle istanze di MyClass
	@GetMapping("/mygetallclasses")
	public List<MyClass> myGetAllClasses() {			
		return myClasses;
	}
		
	@DeleteMapping("deleteclassbymystring/{myString}")
	public List<MyClass> deleteClassByMyString(@PathVariable String myString) {		
		myClasses.removeIf(myClass -> myClass.getMyString().equalsIgnoreCase(myString));		
		return myClasses;
	}
		
		
}
