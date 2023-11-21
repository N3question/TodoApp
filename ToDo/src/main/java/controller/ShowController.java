package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TodoModel;
import model.bean.TodoBeans;

@WebServlet("/show")
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listId = Integer.parseInt(request.getParameter("list_id"));
		
		TodoModel todoModel = new TodoModel();
		TodoBeans todoSelect = todoModel.todoSelect(listId);
		request.setAttribute("todoSelect", todoSelect);
		
		String view = "/WEB-INF/views/show.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
