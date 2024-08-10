package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Contribution;

public class UpdateDialyDAO {
	// DB接続に使用する情報
	private String DATABASE_NAME = "dialy";
	private String PROPATIES = "?characterEncoding=UTF-8&useSSL=false";
	private String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
	private String USER = "root";
	private String PASSWORD = "password";
	
	public boolean execute(Contribution contribution) {
		System.out.println("UpdateDialyDAO呼び出し成功");
		
		// 結果返却用の変数
		int num = 0;
		try {
			// MySQLに接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する。
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// クエリを渡す
			String sql = "update dialy set title = \"" + contribution.getTitle() + "\", text = \"" + contribution.getText() + "\", updateDatetime = CURRENT_TIMESTAMP where id = \"" + contribution.getId() + "\";";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// 確認用
			System.out.println(sql);
			
			// クエリを実行する
			num = pStmt.executeUpdate();
			
			// MySQLとの接続を切断する
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(num > 0) {
			return true;
		}
		
		// 確認用
		System.out.println(num);
		
		return false;
	}

}
