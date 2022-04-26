package sri.sai.bhavani.printers.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sri.sai.bhavani.printers.website.service.TodoService;

@Controller
public class TodoController {
   
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodos(ModelMap model) {
		model.put("todos",todoService.retrieveTodo("bhavani"));
		return "listtodos";
	}
	

}
