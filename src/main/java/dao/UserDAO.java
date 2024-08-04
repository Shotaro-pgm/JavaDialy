package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO {
	private String id;
	private String password;
	
	// DB接続に使用する情報
	private String DATABASE_NAME = "dialy";
	private String PROPATIES = "?characterEncoding=UTF-8&useSSL=false";
	private String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
	private String USER = "root";
	private String PASSWORD = "password";
	
	public UserDAO() {}
	public UserDAO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public List<User> execute(String paramId, String paramPassword){
		List<User> userList = new ArrayList();
		
		try {
			// MySQLに接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する。
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// クエリを渡す
			String sql = "select * from user where id = \"" + paramId + "\" and password = \"" + paramPassword + "\";";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// クエリを実行して結果を取得する
			ResultSet rs = pStmt.executeQuery();
			
			/*
			// MySQLとの接続を切断する
			conn.close();
			*/
			
			// 取得した結果を格納する
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				User user = new User(id, name, password);
				userList.add(user);
			}
			
			// MySQLとの接続を切断する
			conn.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
}
