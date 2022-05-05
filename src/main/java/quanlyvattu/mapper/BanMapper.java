package quanlyvattu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlyvattu.model.BanModel;


public class BanMapper implements RowMapper<BanModel>{
	@Override
	public BanModel mapRow(ResultSet resultSet) {
		try {
			BanModel obj = new BanModel();
			obj.setiD(resultSet.getLong("ID"));
			obj.setSoGhe(resultSet.getInt("SOGHE"));
			obj.setLoai(resultSet.getLong("LOAI"));

			return obj;
		} catch (SQLException e) {
			return null;
		}	
	}
}  
