package quanlyvattu.repositoryCN1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import quanlyvattu.entity.DatHangEntity;
import quanlyvattu.entity.NhanVienEntity;



public interface NhanVienRepositoryCN1 extends JpaRepository<NhanVienEntity, Integer> {
	@Query(value  = "exec sp_TraCuu_TimMaNV", nativeQuery = true)
	int TimMaNV();
	
	
	@Query("select nv from NhanVienEntity nv where nv.trangThaiXoa = 0")
	List<NhanVienEntity> findAllNV();
}
