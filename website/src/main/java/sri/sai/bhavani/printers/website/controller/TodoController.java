package sri.sai.bhavani.printers.website.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sri.sai.bhavani.printers.website.service.TodoService;

@Controller

@SessionAttributes("name")
public class TodoController {
   
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
		String name = (String)model.get("name");
		model.put("todos", service.retrieveTodo(name));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String showaddTodoPage(ModelMap model){
		return "todo";
	}
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc){
		service.addTodo((String) model.get("name"), desc, false, new Date());
	
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id){
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

}
