package sri.sai.bhavani.printers.website.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import sri.sai.bhavani.printers.website.model.Todo;

@Component
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int count = 3;
	 
	static {
	 todos.add(new Todo(1,"bhavani","microservices",false, new Date()));
	 todos.add(new Todo(2,"pooja","nginx",false, new Date()));
	 todos.add(new Todo(3,"kiranmayee","cooking",false, new Date()));
    }
	
	
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	
	public void addTodo(String name, String desc, Boolean isdone, Date date) {
		todos.add(new Todo(++count,name,desc,isdone,date));
	}
	
	//retrieve todos of specific user
	public List<Todo> retrieveTodo(String user) {
		List<Todo> filteredTodosOfUser = new ArrayList<Todo>();
		for(Todo todo : todos) {
			if(todo.getUser().equals(user)) {
				filteredTodosOfUser.add(todo);
			}
		}
		return filteredTodosOfUser;
	}
}
