package model;

import java.util.List;

import bean.User;
import dao.UserDAO;

public class LoginLogic {
	private String id;
	private String password;
	
	public LoginLogic() {}
	public LoginLogic(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public User execute() {
		// UserDAOを利用してユーザー情報を取得する
		UserDAO userDao = new UserDAO();
		List<User> userList = userDao.execute(this.id, this.password);
		
		User userBean = new User();
		boolean result = false;
		// userDAOの中身をみてユーザー登録されているかどうかを判定する
		for(User user : userList) {
			if(user.getId() != null && user.getPassword() != null) {
				userBean.setId(user.getId());
				userBean.setName(user.getName());
				userBean.setPassword(user.getPassword());
			}
		}
		
		return userBean;
		
	}

}
