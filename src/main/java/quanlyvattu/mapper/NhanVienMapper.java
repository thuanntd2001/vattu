package quanlyvattu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlyvattu.model.NhanVienModel;

public class NhanVienMapper implements RowMapper<NhanVienModel>{
	@Override
	public NhanVienModel mapRow(ResultSet resultSet) {
		try {
			NhanVienModel nhanVien = new NhanVienModel();
			nhanVien.setMaNV(resultSet.getInt("MANV"));
			nhanVien.setHoTen(resultSet.getString("HOTEN"));
			nhanVien.setTenNhom(resultSet.getString("TENNHOM"));
			return nhanVien;
		} catch (SQLException e) {
			return null;
		}	
	}
}
