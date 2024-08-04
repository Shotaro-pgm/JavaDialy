package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Contribution;

public class DetailDAO {
	// DB接続に使用する情報
	private String DATABASE_NAME = "dialy";
	private String PROPATIES = "?characterEncoding=UTF-8&useSSL=false";
	private String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
	private String USER = "root";
	private String PASSWORD = "password";
	
	public Contribution execute(String id) {
		Contribution contribution = new Contribution();
		
		try {
			// MySQLに接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// クエリを渡す
			String sql = "select id, title, text, createdDatetime, updateDatetime from dialy where id = \"" + id + "\";";
			// 確認用
			System.out.print(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// クエリを実行して結果を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 取得した結果を格納する
			while(rs.next()) {
				String contId = rs.getString("id");
				String title = rs.getString("title");
				String text = rs.getString("text");
				String createdDatetime = rs.getString("createdDatetime");
				String updateDatetime = rs.getString("updateDatetime");
				
				contribution.setUserId(contId);
				contribution.setTitle(title);
				contribution.setText(text);
				contribution.setCreatedDatetime(createdDatetime);
				contribution.setUpdateDatetime(updateDatetime);
				
			}
			
			// MySQLとの接続を切断する
			conn.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return contribution;
	}

}
