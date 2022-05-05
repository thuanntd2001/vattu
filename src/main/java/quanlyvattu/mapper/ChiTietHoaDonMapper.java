package quanlyvattu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlyvattu.model.ChiTietHoaDonModel;

public class ChiTietHoaDonMapper  implements RowMapper<ChiTietHoaDonModel>{
	@Override
	public ChiTietHoaDonModel mapRow(ResultSet resultSet) {
		try {
			ChiTietHoaDonModel obj = new ChiTietHoaDonModel();
			obj.setMaHD(resultSet.getLong("MAHD"));
			obj.setMaSP(resultSet.getString("MASP"));
			obj.setSoLuong(resultSet.getInt("SOLUONG"));
			return obj;
		} catch (SQLException e) {
			return null;
		}	
	}

}
