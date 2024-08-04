package model;

import bean.Dialy;
import dao.InsertDialyDAO;

public class InsertLogic {
	public boolean execute(Dialy dialy) {
		InsertDialyDAO insertDialyDAO = new InsertDialyDAO();
		return insertDialyDAO.execute(dialy);
		
	}

}
