package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Contribution;
import model.DetailLogic;

@WebServlet("/detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// パラメータから投稿のIDを取得する
		String id = request.getParameter("id");
		
		// 投稿詳細取得のロジッククラスを呼び出す
		DetailLogic dl = new DetailLogic();
		Contribution contribution = new Contribution();
		contribution = dl.execute(id);
		
		// 取得した情報をセッションスコープに保存する
		HttpSession session = request.getSession();
		session.setAttribute("contribution", contribution);
		
		response.sendRedirect("detail.jsp");
		
	}

}
