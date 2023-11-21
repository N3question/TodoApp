package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.bean.TodoBeans;
import model.bean.UserBeans;

public class UserDao {
	private final String URL = "jdbc:mysql://localhost/TodoApp";
	private final String USER = "root";
	private final String PASSWORD = "";
	
	public UserBeans select(String name, String password) {
		UserBeans userbeans = new UserBeans();
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        
        	String SQL = "SELECT * FROM users WHERE name = ? AND password = ?"; // AND追加
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
            	int user_id = result.getInt("user_id");
            	String user_name = result.getString("name");
            	userbeans.setUserId(user_id);
            	userbeans.setName(user_name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userbeans;
    }
	
	public UserBeans insert(String name, String password) {
		UserBeans userbeans = new UserBeans();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // cjを追加。念の為
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        String SQL = "INSERT INTO users (name, password) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, name);
     		statement.setString(2, password);
     		statement.executeUpdate();
     		
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userbeans;
    }
	
	public ArrayList<TodoBeans> getUserTodoAll(int userId) {
		ArrayList<TodoBeans> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
 
        	String SQL = "SELECT * FROM lists WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                int listId = result.getInt("list_id");
                String title = result.getString("title");
                String content = result.getString("content");
                Date date = result.getDate("date");
                String priority = result.getString("priority");
                int usetId = result.getInt("user_id");
                TodoBeans todoBeans = new TodoBeans(listId, title, content, date, priority, usetId);
                empList.add(todoBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
	
}
