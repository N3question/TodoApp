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

@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBeans user = (UserBeans)session.getAttribute("userInfo");
		
		UserModel userModel = new UserModel();
	    ArrayList<TodoBeans> todoList = userModel.userTodoFindAll(user.getUserId());
	    request.setAttribute("todoList", todoList); 
	    
		String view = "/WEB-INF/views/myPage.jsp";
	    getServletContext().getRequestDispatcher(view).forward(request, response);
	}
	// FIXME userIdを含んだ上でPOST通信をさせる 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォームの値を取得
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String priority = request.getParameter("priority");
		
		// todoInsertメソッドのインスタンス化
		TodoModel todoModel = new TodoModel();
		todoModel.todoInsert(title, content, priority);
		
		// DB接続を再度行う（SELECTのSQL処理が走る）
		ArrayList<TodoBeans> todoList = todoModel.todoFindAll();
	    request.setAttribute("todoList", todoList);
		
	    // 遷移先
		String indexView = "/WEB-INF/views/index.jsp";
	    getServletContext().getRequestDispatcher(indexView).forward(request, response);
	}

}
