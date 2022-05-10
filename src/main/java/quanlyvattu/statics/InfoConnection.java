package quanlyvattu.statics;

public class InfoConnection {

	private static String userName="sa";
	private static String passWord="1234";
	private static String url="jdbc:sqlserver://TBTUONGLAI1; Database=QLVT_DATHANG";
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		InfoConnection.userName = userName;
	}
	public static String getPassWord() {
		return passWord;
	}
	public static void setPassWord(String passWord) {
		InfoConnection.passWord = passWord;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		InfoConnection.url = "jdbc:sqlserver://"+url+"; Database=QLVT_DATHANG";
	}
	public static String getDriver() {
		return driver;
	}
	public static void setDriver(String driver) {
		InfoConnection.driver = driver;
	}

}
