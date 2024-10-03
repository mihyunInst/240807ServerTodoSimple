package edu.kh.todolist.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.dao.TodoListDao;
import edu.kh.todolist.dao.TodoListDaoImpl;
import edu.kh.todolist.dto.Todo;

public class TodoListServiceImpl implements TodoListService{

	private TodoListDao dao = null;
	
	// 기본 생성자
	public TodoListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		// 객체 생성 시 TodoListDAO 객체 생성
		dao = new TodoListDaoImpl();
	}
	
	
	@Override
	public List<Todo> todoListFullView() {
		
		// 할 일 목록 얻어오기 
		List<Todo> todoList = dao.todoListFullView();
		return todoList;
	}
	
	// -------------------------------------------------------------------------------------------------

	
	@Override
	public Todo todoDetailView(int index) {
		Todo todo = dao.todoDetailView(index);
		return todo;
	}
	
	//-------------------------------------------------------------------------------------------------
	
	
	@Override
	public int todoAdd(String title, String detail) throws FileNotFoundException, IOException {
		
		Todo todo = new Todo(title, detail);
		
		return dao.todoAdd(todo);
	}

	
	
}
