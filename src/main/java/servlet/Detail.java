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
		
		// 確認用
		System.out.println(contribution.getId());
		
		// 取得した情報をセッションスコープに保存する
		HttpSession session = request.getSession();
		session.setAttribute("contribution", contribution);
		
		response.sendRedirect("detail.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// 投稿のIDを取得する
		HttpSession session = request.getSession();
		Contribution contribution = (Contribution)session.getAttribute("contribution");
		String id = contribution.getId();
		
		// 確認用
		System.out.println(id);
		
		// 投稿詳細取得のロジッククラスを呼び出す
		DetailLogic dl = new DetailLogic();
		contribution = dl.execute(id);
				
		// 取得した情報をセッションスコープに保存する
		session.setAttribute("contribution", contribution);
				
		response.sendRedirect("detail.jsp");
	}

}
