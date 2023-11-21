// DBから取得した一件分のデータを格納する倉庫の役割
package model.bean;

import java.io.Serializable;
import java.util.Date;

// シリアル化？ 
public class TodoBeans implements Serializable {
	private int listId;
	private String title;
	private String content;
	private Date date;
	private String priority;
	private int userId;
	
	public TodoBeans() {} // 空のコンストラクタ => Beansの特徴
	public TodoBeans(int listId, String title, String content, Date date, String priority, int userId) {
		this.listId = listId;
		this.title = title;
		this.content = content;
		this.date = date;
		this.priority = priority;
		this.userId = userId;
 	}
	
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}