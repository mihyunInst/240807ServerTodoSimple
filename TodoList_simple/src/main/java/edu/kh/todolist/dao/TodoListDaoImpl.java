package edu.kh.todolist.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.kh.todolist.dto.Todo;

public class TodoListDaoImpl implements TodoListDao{
	// C:/servlet_todoList_data 폴더 미리 생성해놓기
	private final String FILE_PATH = "/servlet_todoList_data/TodoList.dat";
	
	private List<Todo> todoList = null;
	
	private ObjectOutputStream oos = null;
	private ObjectInputStream	 ois = null;
	
	
	// 기본 생성자
	public TodoListDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// TodoList.dat 파일이 없으면 새로운 List 생성, 있으면 읽어오기
		File file = new File(FILE_PATH);
		
		System.out.println(file.getAbsolutePath()); // 파일 위치 : 해당 IDE 설치 파일 폴더
		
		if(!file.exists()) {
			todoList = new ArrayList<Todo>();
			
			todoList.add(new Todo("Servlet 공부", "수업 내용 복습111"));
			todoList.add(new Todo("JSP 공부", "수업 내용 복습2222"));
			todoList.add(new Todo("TodoList 만들기", "수업 내용 복습333"));
			
		} else {
			try {
				// 객체 생성 시 외부 파일에 작성된 List<Todo> 객체를 입력 받아 todoList에 대입
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				todoList = (ArrayList<Todo>)ois.readObject();
			}finally {
				if(ois != null) ois.close();
			}
		}
		
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	/* TodoList를 파일로 저장 */
	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		// 예외는 throws를 던져 버리기 때문에 catch문 불필요
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(todoList);
		}finally {
			oos.close(); // 예외 발생 여부 관계 없이 무조건 닫기!
		}
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	
	@Override
	public List<Todo> todoListFullView() {
		return todoList;
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
	
	@Override
	public Todo todoDetailView(int index) {
		
		// TodoList 범위 초과 시 null 반환
		if(index < 0 || index >= todoList.size()) return null;
		
		return todoList.get(index);
	}
	

	
	//-------------------------------------------------------------------------------------------------
	
	
	@Override
	public int todoAdd(Todo todo) throws FileNotFoundException, IOException {
		
		// 객체 출력 스트림 생성
		
		if(todoList.add(todo)) {
			saveFile();
			return todoList.size() - 1; // 마지막 인덱스 번호 반환
		}
		
		return -1;
	}

	
}
