package model;

import java.util.ArrayList;

import model.bean.TodoBeans;
import model.dao.TodoDao;

public class TodoModel {
	public ArrayList<TodoBeans> todoFindAll() {
		// 設計図（クラス）の実体化
		TodoDao todoDao = new TodoDao();
		ArrayList<TodoBeans> todoList = todoDao.getDataFromDatabase();
		return todoList;
	}
	
	public TodoBeans todoSelect(int listId) {
		TodoDao todoDao = new TodoDao();
		TodoBeans todo = todoDao.select(listId);
		return todo;
	}
	
	public ArrayList<TodoBeans> todoSelectSortDescAbc() {
		TodoDao todoDao = new TodoDao();
		ArrayList<TodoBeans> sortDescAbc = todoDao.getSortDescAbc();
		return sortDescAbc;
	}
	
	public ArrayList<TodoBeans> todoSelectSortAscAbc() {
		TodoDao todoDao = new TodoDao();
		ArrayList<TodoBeans> sortAscAbc = todoDao.getSortAscAbc();
		return sortAscAbc;
	}
	
	public ArrayList<TodoBeans> todoSelectSortDescDate() {
		TodoDao todoDao = new TodoDao();
		ArrayList<TodoBeans> sortDescDate = todoDao.getSortDescDate();
		return sortDescDate;
	}
	
	public ArrayList<TodoBeans> todoSelectSortDescPriority() {
		TodoDao todoDao = new TodoDao();
		ArrayList<TodoBeans> sortDescPriority = todoDao.getSortDescPrirority();
		return sortDescPriority;
	}
	
	public ArrayList<TodoBeans> todoSelectSortAscPriority() {
		TodoDao todoDao = new TodoDao();
		ArrayList<TodoBeans> sortAscPriority = todoDao.getSortAscPrirority();
		return sortAscPriority;
	}
	
	public void todoInsert(String title, String content, String priority) {
		TodoDao todoDao = new TodoDao();
		todoDao.insert(title, content, priority);
	}
	
	public void todoUpdate(int listId, String title, String content, String priority) {
		TodoDao todoDao = new TodoDao();
		todoDao.update(listId, title, content, priority);
	}
	
	public void todoDestroy(int listId) {
		TodoDao todoDao = new TodoDao();
		todoDao.destroy(listId);
	}
}
