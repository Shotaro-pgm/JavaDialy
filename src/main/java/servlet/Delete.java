package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DeleteLogic;

@WebServlet("delete")
public class Delete extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// 確認用
		System.out.println("コントローラ到達");
		
		// パラメータを取得
		String id = request.getParameter("id");
		
		// ロジッククラスのメソッドを呼び出し
		DeleteLogic deleteLogic = new DeleteLogic();
		deleteLogic.execute(id);
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);
	}

}
