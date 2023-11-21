package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;
import model.bean.TodoBeans;

@WebServlet("/destroy")
public class DestroyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DestroyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listId = Integer.parseInt(request.getParameter("list_id"));
		
		TodoModel todoModel = new TodoModel();
		todoModel.todoDestroy(listId);
		
	    ArrayList<TodoBeans> todoList = todoModel.todoFindAll();
	    request.setAttribute("todoList", todoList);
	    
		String view = "/WEB-INF/views/index.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}
}
