package quanlyvattu.dao;

import quanlyvattu.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);

	UserModel findByEmail(String email);


}
