package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Contribution;
import bean.User;
import model.ListLogic;

@WebServlet("/list")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		System.out.println("ログイン処理は完了");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		// 投稿取得のロジックを呼び出す
		ListLogic listLogic = new ListLogic();
		java.util.List<Contribution> contributionList = listLogic.execute(user);
		
		session.setAttribute("contributionList", contributionList);
		
		// ホーム画面にリダイレクト
		response.sendRedirect("home.jsp");
	}
}