package com.dmainali.todolist;

import com.dmainali.todolist.model.TodoItem;
import com.dmainali.todolist.repository.TodoRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodolistApplicationTests {

	@Autowired
	TodoRepo todoRepo;

	@Test
	@Order(1)
	public void testCreate() {
		TodoItem todoItem = new TodoItem();
		todoItem.setId(-100L);
		todoItem.setTitle("Test Title");
		todoItem.setDescription("Test Description");
		todoItem.setDone(true);
		todoRepo.save(todoItem);
		assertNotNull(todoRepo.findById(-100L).get());
	}

	@Test
	@Order(2)
	public void toRead(){
		List<TodoItem> todoItemList = todoRepo.findAll();
		assertThat(todoItemList).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSingleItem(){
		TodoItem todoItem = todoRepo.findById(-100L).get();
		assertEquals("Test Title",todoItem.getTitle());
	}

	@Test
	@Order(4)
	public void testUpdate(){
		TodoItem todoItem = todoRepo.findById(-100L).get();
		todoItem.setDone(false);
		todoRepo.save(todoItem);
		assertNotEquals(true,todoRepo.findById(-100L).get().isDone());
	}

	@Test
	@Order(5)
	public void testDelete(){
		todoRepo.deleteById(-100L);
		assertThat(todoRepo.existsById(-100L)).isFalse();
	}
}

