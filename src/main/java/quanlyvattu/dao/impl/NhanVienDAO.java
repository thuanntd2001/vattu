package quanlyvattu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import quanlyvattu.dao.INhanVienDAO;
import quanlyvattu.entity.NhanVienEntity;
import quanlyvattu.mapper.NhanVienMapper;
import quanlyvattu.model.NhanVienLoginModel;

public class NhanVienDAO extends AbstractDAO<NhanVienLoginModel> implements INhanVienDAO{
/*	@PersistenceContext
	EntityManager entityManager;

	public List<NhanVienEntity> findAll(){
		
		String hql = "FROM NhanVienEntity ";
		
		return entityManager
			     .createQuery(hql, NhanVienEntity.class)
			     .getResultList();
	}*/

	/*public NhanVienLoginModel findOne(long id) {
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
