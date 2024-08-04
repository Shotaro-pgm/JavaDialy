package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.User;
import model.LoginLogic;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// 渡されたリクエストパラメータを取得
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// パラメータを渡してログイン実行メソッドを呼び出す
		LoginLogic loginLogic = new LoginLogic(id, password);
		User user = loginLogic.execute();
		
		System.out.println("ログイン処理は完了");
		// 画面遷移
		if(user.getId() != null && user.getPassword() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			//  確認用
			User loginUser = (User)session.getAttribute("user");
			System.out.println(loginUser.getId());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
			dispatcher.forward(request, response);
		}
	}

}
