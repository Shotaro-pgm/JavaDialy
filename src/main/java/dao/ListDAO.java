package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contribution;

public class ListDAO {
	// DB接続に使用する情報
	private String DATABASE_NAME = "dialy";
	private String PROPATIES = "?characterEncoding=UTF-8&useSSL=false";
	private String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
	private String USER = "root";
	private String PASSWORD = "password";
	
	public List<Contribution> execute(String id){
		List<Contribution> contributionList = new ArrayList();
		
		try {
			// MySQLに接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する。
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// クエリを渡す
			String sql = "select id, title, createdDatetime from dialy where userId =\"" + id + "\";";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// クエリを実行して結果を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 取得した結果を格納する
			while(rs.next()) {
				String contrId = rs.getString("id");
				String title = rs.getString("title");
				String createdDatetime = rs.getString("createdDatetime");
				Contribution contribution = new Contribution(contrId, title, createdDatetime);
				contributionList.add(contribution);
				
				// 確認用
				System.out.println(contrId);
				System.out.println(title);
				System.out.println(createdDatetime);
				for(Contribution c : contributionList) {
					System.out.println(c.getTitle());
				}
			}
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return contributionList;
	}

}
