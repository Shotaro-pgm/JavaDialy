package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Contribution;
import bean.User;
import model.UpdateLogic;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// リクエストパラメータを変数に格納する
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String id = request.getParameter("id");
		System.out.println(id);
		
		// ログインユーザの情報を取得する
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("user");
		String userId = loginUser.getId();
		
		// JavaBeanに格納する
		Contribution contribution = new Contribution();
		contribution.setId(id);
		contribution.setTitle(title);
		contribution.setText(text);
		contribution.setUserId(userId);
		
		// 日記の編集ロジックを呼び出す
		UpdateLogic updateLogic = new UpdateLogic();
		updateLogic.execute(contribution);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/detail");
		dispatcher.forward(request, response);
		
	}

}
