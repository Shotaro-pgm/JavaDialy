package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Dialy;

public class InsertDialyDAO {
	// DB接続に使用する情報
		private String DATABASE_NAME = "dialy";
		private String PROPATIES = "?characterEncoding=UTF-8&useSSL=false";
		private String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
		private String USER = "root";
		private String PASSWORD = "password";
	
	public boolean execute(Dialy dialy) {
		int num = 0;
		try {
			// MySQLに接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する。
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// クエリを渡す
			String sql = "insert into dialy (title, text, userId, createdDatetime) values (\"" + dialy.getTitle() + "\", \"" + dialy.getText() + "\", \"" + dialy.getUserId() + "\", CURRENT_TIMESTAMP);";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// クエリを実行する
			num = pStmt.executeUpdate();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(num > 0) {
			return true;
		}
		return false;
	}

}
