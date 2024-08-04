package model;

import bean.Contribution;
import dao.DetailDAO;

public class DetailLogic {
	public Contribution execute(String id) {
		// DAOクラスの実行メソッドを呼び出す
		Contribution contribution = new Contribution();
		DetailDAO detailDao = new DetailDAO();
		contribution = detailDao.execute(id);
		
		// 取得結果を呼び出し元に返す
		return contribution;
	}
	

}
