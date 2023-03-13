package it.lanadantas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menurestcontroller")
public class MenuRestController {
	@Autowired
	private ApplicationContext myContext;
			
	@GetMapping("/getmenu")
	public Menu myMenu() {			
		Menu myMenu = myContext.getBean("myMenu", Menu.class);
		System.out.println(myMenu.getConsumazioni());
	return myMenu;
	}
	
}
