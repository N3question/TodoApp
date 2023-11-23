package model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.bean.TodoBeans;
import model.bean.UserBeans;
import model.dao.TodoDao;
import model.dao.UserDao;
import model.utils.HashGenerator;

public class UserModel {
	// sessionに保持しているデータを受け取るのでreturnが不要
	public void userSelect(String name, String password, HttpServletRequest request) { 
		String hashedPassword = "";
		try {
			hashedPassword = HashGenerator.generateHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		UserDao userDao = new UserDao();
		UserBeans userInfo = userDao.select(name, hashedPassword);
		
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", userInfo);
	}
	
	public void userInsert(String name, String password) {
		// TODO ここに書くべきなのか河原田さんに聞く
		try {
			String hashedPassword = HashGenerator.generateHash(password);
			UserDao userDao = new UserDao();
			userDao.insert(name, hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	// 以下記述途中
	public void userUpdate(int listId, String title, String content, String priority) {
		TodoDao todoDao = new TodoDao();
		todoDao.update(listId, title, content, priority);
	}
	
	public ArrayList<TodoBeans> userTodoFindAll(int userId) {
		UserDao userDao = new UserDao();
		ArrayList<TodoBeans> todoList = userDao.getUserTodoAll(userId);
		return todoList;
	}
	// ここまで
}
