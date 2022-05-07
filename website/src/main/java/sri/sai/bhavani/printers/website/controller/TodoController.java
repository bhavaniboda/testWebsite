package sri.sai.bhavani.printers.website.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sri.sai.bhavani.printers.website.model.Todo;
import sri.sai.bhavani.printers.website.service.TodoService;

@Controller

@SessionAttributes("name")
public class TodoController {
   
	
	@Autowired
	TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
		String name = getLoggedInUserName(model);
		model.put("todos", service.retrieveTodo(name));
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		return (String)model.get("name");
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String showaddTodoPage(ModelMap model){
		model.addAttribute("todo", new Todo(0,getLoggedInUserName(model),"default desc",false, new Date()));
		return "todo";
	}
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result){
		
		if(result.hasErrors()) {
			return "todo";
		}
		service.addTodo(getLoggedInUserName(model), todo.getDesc(), false, todo.getTargetDate());
		
	
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id){
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	
	@RequestMapping(value="/update-todo", method = RequestMethod.GET)
	public String showupdateTodoPage(@RequestParam int id, ModelMap model){
		Todo todo = service.retrieveTodobyId(id);
		model.put("todo", todo);
		return "todo";
		
	}
	
	@RequestMapping(value="/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	
}
