package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Dialy;
import bean.User;
import model.InsertLogic;

@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("insert.jsp");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		System.out.println("コントローラ到達");
		// リクエストパラメータを変数に格納する
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		
		// ログインユーザの情報を取得する
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("user");
		String userId = loginUser.getId();
		
		// 確認用
		System.out.println(userId);
		
		// JavaBeanに格納する
		Dialy dialy = new Dialy(title, text, userId);
		
		// 日記の投稿ロジックを呼び出す
		InsertLogic insertLogic = new InsertLogic();
		boolean result = insertLogic.execute(dialy);
		System.out.println(result);
		
		// 個別記事に遷移する
		// 詳細表示画面作成後は投稿した記事に飛ばすようにする
		// home.jspは仮置き
		// response.sendRedirect("/list");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);
		
	}

}
