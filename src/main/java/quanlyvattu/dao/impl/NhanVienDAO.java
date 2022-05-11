package quanlyvattu.dao.impl;

import java.util.List;

import quanlyvattu.dao.INhanVienDAO;
import quanlyvattu.mapper.NhanVienMapper;
import quanlyvattu.model.NhanVienLoginModel;

public class NhanVienDAO extends AbstractDAO<NhanVienLoginModel> implements INhanVienDAO{
/*	public List<NhanVienLoginModel> findAll(){
		String sql = "SELECT * FROM dbo.NHANVIEN";
		return query(sql,new NhanVienMapper());
	}

	public NhanVienLoginModel findOne(long id) {
		String sql = "SELECT * FROM dbo.NHANVIEN NV WHERE MANV=?";
		List<NhanVienLoginModel> nv= query(sql,new NhanVienMapper(),id);
		return nv.isEmpty()?null:nv.get(0);
	}*/
	
	public NhanVienLoginModel login(String userName){
		String sql = "EXEC	sp_DangNhap ?";
		List<NhanVienLoginModel> nv =query(sql,new NhanVienMapper(),userName);
		return nv==null? null:nv.get(0);
	}
}
