package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;
import model.bean.TodoBeans;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listId = Integer.parseInt(request.getParameter("list_id")); // URLに表示されている値を取得
		
		// データベースにアクセスして１レコードを取得する
		TodoModel todoModel = new TodoModel();
		TodoBeans todoSelect = todoModel.todoSelect(listId);
		// 取得したテーブルのrowをsetAttribute
		request.setAttribute("todoSelect", todoSelect);
		
		String indexView = "/WEB-INF/views/edit.jsp";
	    getServletContext().getRequestDispatcher(indexView).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listId = Integer.parseInt(request.getParameter("list_id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String priority = request.getParameter("priority");
		
		TodoModel todoModel = new TodoModel();
		todoModel.todoUpdate(listId, title, content, priority);
		
		TodoBeans todoSelect = todoModel.todoSelect(listId);
		request.setAttribute("todoSelect", todoSelect);
		
		String view = "/WEB-INF/views/show.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}

}
