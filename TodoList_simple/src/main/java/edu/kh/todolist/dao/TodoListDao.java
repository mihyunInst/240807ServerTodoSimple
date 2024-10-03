package edu.kh.todolist.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.todolist.dto.Todo;

/* DAO(Data Access Object) : DB나 파일과 같은 영속성 계층(persistence layer)에 접근하는 로직
 * -> 즉, DB의 데이터를 조회, 삽입, 삭제, 갱신 등의 작업을 수행하는 객체
 * 
 * */
public interface TodoListDao {
	// public abstract를 명시하지 않아도 public abstract으로 해석됨!!

	/**
	 * TodoList를 파일로 저장하는 메서드
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	void saveFile() throws FileNotFoundException, IOException;

	/**
	 * 할 일 목록 반환
	 * 
	 * @return todoList
	 */
	List<Todo> todoListFullView();

	/**
	 * 전달 받은 index 번째 todo를 반환
	 * 
	 * @param index
	 * @return index 번째 todo, 없으면 null
	 */
	Todo todoDetailView(int index);

	/**
	 * 할 일 추가
	 * 
	 * @param todo
	 * @return 추가된 index 번호 반환
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	int todoAdd(Todo todo) throws FileNotFoundException, IOException;

}
