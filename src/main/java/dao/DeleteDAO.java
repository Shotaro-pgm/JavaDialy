package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
	// DB接続に使用する情報
	private String DATABASE_NAME = "dialy";
	private String PROPATIES = "?characterEncoding=UTF-8&useSSL=false";
	private String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
	private String USER = "root";
	private String PASSWORD = "password";
	
	public void execute(String id) {
		try {
			// MySQLに接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// クエリを渡す
			String sql = "delete from dialy where id = \"" + id + "\";";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// クエリ実行
			pStmt.executeUpdate(sql);
			
			// MySQLとの接続を切断する
			conn.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
