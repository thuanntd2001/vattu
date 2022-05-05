package quanlyvattu.dao.impl;

import java.util.List;

import quanlyvattu.dao.IUserDAO;
import quanlyvattu.mapper.UserMapper;
import quanlyvattu.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
	StringBuilder sql = new StringBuilder("SELECT * FROM USERTB");
	sql.append(" WHERE username = ? AND passwd = ? AND status = ?");
	List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
	return users.isEmpty() ? null : users.get(0);
}

	@Override
	public UserModel findByEmail(String email) {

		StringBuilder sql = new StringBuilder("SELECT * FROM USERTB");
		sql.append(" WHERE email = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), email);
		return users.isEmpty() ? null : users.get(0);
	}

}
