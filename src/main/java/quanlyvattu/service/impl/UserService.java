package quanlyvattu.service.impl;

import quanlyvattu.dao.IUserDAO;
import quanlyvattu.dao.impl.UserDAO;
import quanlyvattu.model.UserModel;
import quanlyvattu.service.IUserService;

public class UserService implements IUserService{
	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

	@Override
	public UserModel findByEmail(String email) {
		return userDAO.findByEmail(email);
	
	}
}
