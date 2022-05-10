package quanlyvattu.statics;

public class InfoConnection {
	private static String chiNhanh;
	private static String userName="sa";
	private static String passWord="1234";
	private static String url="jdbc:sqlserver://TBTUONGLAI1\\SQLSV1; Database=QLVT_DATHANG";
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String getChiNhanh() {
		return chiNhanh;
	}
	public static void setChiNhanh(String chiNhanh) {
		InfoConnection.chiNhanh = chiNhanh;
	}
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
		InfoConnection.url = url;
	}
	public static String getDriver() {
		return driver;
	}
	public static void setDriver(String driver) {
		InfoConnection.driver = driver;
	}

}
