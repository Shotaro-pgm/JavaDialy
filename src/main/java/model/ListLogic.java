package model;

import java.util.List;

import bean.Contribution;
import bean.User;
import dao.ListDAO;

public class ListLogic {
	public List<Contribution> execute(User user) {
		String id = user.getId();
		
		// DAOを呼び出す
		ListDAO listDao = new ListDAO();
		List<Contribution> contributionList = listDao.execute(id);
		
		return contributionList;
	}

}
