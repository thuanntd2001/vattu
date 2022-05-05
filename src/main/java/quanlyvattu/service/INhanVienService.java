package quanlyvattu.service;

import java.util.List;

import quanlyvattu.model.NhanVienModel;


public interface INhanVienService {

	List<NhanVienModel> findAll();
	NhanVienModel findOne(long id);
}
