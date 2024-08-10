package model;

import dao.DeleteDAO;

public class DeleteLogic {
	public void execute(String id) {
		DeleteDAO deleteDao = new DeleteDAO();
		deleteDao.execute(id);
	}

}
