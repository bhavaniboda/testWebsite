package sri.sai.bhavani.printers.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sri.sai.bhavani.printers.website.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loginMessage(ModelMap model){
		//model.put("name",name);
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String showWelcomePageMessage(@RequestParam String name, ModelMap model,@RequestParam String password){
		boolean result = service.isValidUser(name,password);
		if(result) {
		model.put("name",name);
		model.put("password",password);

		return "welcome";
		}
		else {
			model.put("errorMessage", "Invalid credentials");
			return "login";
		}
	}
}
