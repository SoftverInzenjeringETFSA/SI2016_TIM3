package ba.eventTS.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "Test controller"; 
	}
//ZIvinic
}
