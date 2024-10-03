package edu.kh.todolist.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.dto.Todo;

// 인터페이스로 만든 이유 : 유연성, 확장성, 유지보수성을 높이기 위함
// 인터페이스를 사용하면 구체적인 구현 클래스에 의존하지 않고, 필요에 따라 구현체(Class)를 쉽게 교체하거나 확장할 수 있음
public interface TodoListService {
	// public abstract를 명시하지 않아도 public abstract으로 해석됨!!

	/**  할 일 목록 반환 서비스
	 * @return todoList + 완료 개수
	 */ 
	/* public abstract */List<Todo> todoListFullView();

	/** 전달 받은 index 번째 todo를 반환
	 * @param index
	 * @return index 번째 todo, 없으면 null 반환
	 */
	/* public abstract */Todo todoDetailView(int index);

	/** 할 일 추가
	 * @param title
	 * @param content
	 * @return 추가된 index 번호 반환, 실패 시 -1
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	/* public abstract */int todoAdd(String title, String detail) throws FileNotFoundException, IOException ;



}
