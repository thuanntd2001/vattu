package quanlyvattu.service.impl;

import java.util.List;

import quanlyvattu.dao.impl.NhanVienDAO;
import quanlyvattu.model.NhanVienModel;
import quanlyvattu.service.INhanVienService;


public class NhanVienService implements INhanVienService{
	
	private NhanVienDAO nhanVienDAO = new NhanVienDAO(); 
	
	public List<NhanVienModel> findAll() {
		return nhanVienDAO.findAll();
	}
	public NhanVienModel findOne(long id) {
		return nhanVienDAO.findOne(id);
		
	}
}
