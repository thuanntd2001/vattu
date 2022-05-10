package quanlyvattu.model;

import quanlyvattu.entity.NhanVienEntity;


public class UserModel {

	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String userName;
	

	private NhanVienEntity usernv;
	
	private int roleID;

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public NhanVienEntity getUsernv() {
		return usernv;
	}


	public void setUsernv(NhanVienEntity usernv) {
		this.usernv = usernv;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	private String passwd;


	
	
}
