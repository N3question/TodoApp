package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/signUp.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// User新規作成
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserModel userModel = new UserModel();
		userModel.userInsert(name, password);
	    request.setAttribute("message", name + " 's account has been successfully created.");
	    String view = "/WEB-INF/views/login.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}

}
