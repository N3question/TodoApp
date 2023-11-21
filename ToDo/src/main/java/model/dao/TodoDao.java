//取得したデータの値を加工するための過程の役割
// DB接続も一緒に行う
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.bean.TodoBeans;

// 設計図（実体なし）
public class TodoDao {
	// DB接続に必要な情報
	private final String url = "jdbc:mysql://localhost/TodoApp";
	private final String user = "root";
	private final String password = "";
    
	// public 戻り値のデータ型　メソッド名() {}
    public ArrayList<TodoBeans> getDataFromDatabase() {
    	// インスタンス化（ = 初期化。データベース クエリの結果を保持するコンテナ)
        ArrayList<TodoBeans> empList = new ArrayList<>();
        
        // JDBCのロード時の例外処理
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        
        // DB接続
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SELECT文を準備
        	String SQL = "SELECT * FROM lists";
            PreparedStatement pStmt = connection.prepareStatement(SQL);
            
            // SELECTを実行し、結果を取得
            ResultSet result = pStmt.executeQuery();
            
            while (result.next()) {
            	// レコードの値を取得
                int listId = result.getInt("list_id");
                String title = result.getString("title");
                String content = result.getString("content");
                Date date = result.getDate("date");
                String priority = result.getString("priority");
                int usetId = result.getInt("user_id");
                // 取得した値を TodoBeans インスタンスに格納
                TodoBeans todoBeans = new TodoBeans(listId, title, content, date, priority, usetId);
                // empList という名前の ArrayList インスタンスに TodoBeans インスタンスを格納
                empList.add(todoBeans);
            }
        // SQL接続時の例外処理
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }

    public ArrayList<TodoBeans> getSortDescAbc() {
        ArrayList<TodoBeans> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String SQL = "SELECT * FROM lists ORDER BY title DESC";
            PreparedStatement pStmt = connection.prepareStatement(SQL);
            ResultSet result = pStmt.executeQuery();
            while (result.next()) {
            	
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
    
    public ArrayList<TodoBeans> getSortAscAbc() {
        ArrayList<TodoBeans> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String SQL = "SELECT * FROM lists ORDER BY title ASC";
            PreparedStatement pStmt = connection.prepareStatement(SQL);
            ResultSet result = pStmt.executeQuery();
            while (result.next()) {
            	
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
    
    public ArrayList<TodoBeans> getSortDescDate() {
        ArrayList<TodoBeans> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String SQL = "SELECT * FROM lists ORDER BY date DESC";
            PreparedStatement pStmt = connection.prepareStatement(SQL);
            ResultSet result = pStmt.executeQuery();
            while (result.next()) {
            	
                int listId = result.getInt("list_id");
                String title = result.getString("title");
                String content = result.getString("content");
                Date date = result.getDate("date");
                String priority = result.getString("priority");
                int userId = result.getInt("user_id");
                TodoBeans todoBeans = new TodoBeans(listId, title, content, date, priority, userId);
     
                empList.add(todoBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
    
    public ArrayList<TodoBeans> getSortDescPrirority() {
        ArrayList<TodoBeans> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String SQL = "SELECT * FROM lists ORDER BY priority DESC";
            PreparedStatement pStmt = connection.prepareStatement(SQL);
            ResultSet result = pStmt.executeQuery();
            while (result.next()) {
            	
                int listId = result.getInt("list_id");
                String title = result.getString("title");
                String content = result.getString("content");
                Date date = result.getDate("date");
                String priority = result.getString("priority");
                int userId = result.getInt("user_id");
                TodoBeans todoBeans = new TodoBeans(listId, title, content, date, priority, userId);
     
                empList.add(todoBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
    
    public ArrayList<TodoBeans> getSortAscPrirority() {
        ArrayList<TodoBeans> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String SQL = "SELECT * FROM lists ORDER BY priority ASC";
            PreparedStatement pStmt = connection.prepareStatement(SQL);
            ResultSet result = pStmt.executeQuery();
            while (result.next()) {
            	
                int listId = result.getInt("list_id");
                String title = result.getString("title");
                String content = result.getString("content");
                Date date = result.getDate("date");
                String priority = result.getString("priority");
                int userId = result.getInt("user_id");
                TodoBeans todoBeans = new TodoBeans(listId, title, content, date, priority, userId);
     
                empList.add(todoBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
    
    public TodoBeans select(int listId) {
    	TodoBeans todobeans = new TodoBeans();
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            
        	String SQL = "SELECT * FROM lists WHERE list_id = ?";
        	// PreparedStatementは上記SQL文の処理を行うことを定義している
            PreparedStatement statement = connection.prepareStatement(SQL);
            // そこにsetする内容の定義
            statement.setInt(1, listId);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
            	result.getInt("list_id");
				result.getString("title");
				result.getString("content");
				result.getDate("date");
				result.getString("priority");
				result.getInt("user_id");
				
				// DB接続して取得した値をtodobeansにセット
				todobeans.setListId(result.getInt("list_id"));
	            todobeans.setTitle(result.getString("title"));
	            todobeans.setContent(result.getString("content"));
	            todobeans.setDate(result.getDate("date"));
	            todobeans.setPriority(result.getString("priority"));
	            todobeans.setUserId(result.getInt("user_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return todobeans;
    }
    
    // userId 未追加 新規追加時にuserIdは入らない
    
    // INSERT文を含んだメソッド(クラスの振る舞い)を定義
    // DBにINSERTする処理。処理内容が毎度同じだからstaticをつけてもいい
    public void insert(String title, String content, String priority) {    	
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        String SQL = "INSERT INTO lists (title, content, date, priority) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
 		PreparedStatement statement = connection.prepareStatement(SQL)){
        	statement.setString(1, title);
     		statement.setString(2, content);
     		statement.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
     		statement.setString(4, priority);
     		statement.executeUpdate();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
    }
    
    
    public void update(int listId, String title, String content, String priority) { 
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        String SQL = "UPDATE lists SET title = ?, content = ?, priority = ? WHERE list_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
        	 PreparedStatement statement = connection.prepareStatement(SQL)){
        	statement.setString(1, title);
     		statement.setString(2, content);
     		statement.setString(3, priority);
     		statement.setInt(4, listId);
     		statement.executeUpdate();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
    }
    
    public void destroy(int listId) { 
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        String SQL = "DELETE FROM lists WHERE list_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
        	 PreparedStatement statement = connection.prepareStatement(SQL)){
        	statement.setInt(1, listId);
        	statement.executeUpdate();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }

    }
}
