package model;

import bean.Contribution;
import dao.UpdateDialyDAO;

public class UpdateLogic {
	public boolean execute(Contribution contribution) {
		UpdateDialyDAO updateDialyDao = new UpdateDialyDAO();
		return updateDialyDao.execute(contribution);
		
	}
	

}
