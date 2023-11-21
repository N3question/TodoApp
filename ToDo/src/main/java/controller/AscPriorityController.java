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

@WebServlet("/ascPriority")
public class AscPriorityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AscPriorityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoModel todoModel = new TodoModel();
		ArrayList<TodoBeans> todoList = todoModel.todoSelectSortAscPriority();
		request.setAttribute("todoList", todoList);
		
		String indexView = "/WEB-INF/views/index.jsp";
	    getServletContext().getRequestDispatcher(indexView).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
