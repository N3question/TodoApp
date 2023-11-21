// ModelとViewの橋渡しを行う役割
package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TodoModel;
import model.UserModel;
import model.bean.TodoBeans;
import model.bean.UserBeans;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoModel todoModel = new TodoModel();
	    ArrayList<TodoBeans> todoList = todoModel.todoFindAll();
	    request.setAttribute("todoList", todoList);
	    
	    HttpSession session = request.getSession();
	    UserBeans user = (UserBeans)session.getAttribute("userInfo");
	    if (user != null) {
		    int userId = user.getUserId();
			String name = user.getName();
			
			request.setAttribute("user", user);
			request.setAttribute("userId", userId);
			request.setAttribute("name", name);
	    }
	    String indexView = "/WEB-INF/views/index.jsp";
	    getServletContext().getRequestDispatcher(indexView).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログイン機能
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			UserModel userModel = new UserModel();
			userModel.userSelect(name, password, request); // モデル内で ログイン実行 + sessionに値をset (void)
			
			// 以下途中
			// TODO URLからのアクセス制御：sessionに保持されているuserIdがnullの場合はlogin画面に遷移する記述を書く
				// null => login.jsp
				// exist => myPage.jsp
			HttpSession session = request.getSession();
			UserBeans user = (UserBeans)session.getAttribute("userInfo");
			request.setAttribute("message", "Welcome " + user.getName() + " !");
			
		    ArrayList<TodoBeans> todoList = userModel.userTodoFindAll(user.getUserId());
		    request.setAttribute("todoList", todoList);
		    
			String view = "/WEB-INF/views/myPage.jsp";
		    getServletContext().getRequestDispatcher(view).forward(request, response);
		}
}
