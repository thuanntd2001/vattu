package quanlyvattu.repositoryCN1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import quanlyvattu.entity.NhanVienEntity;



public interface NhanVienRepositoryCN1 extends JpaRepository<NhanVienEntity, Integer> {
	@Query(value  = "exec sp_TraCuu_TimMaNV", nativeQuery = true)
	int TimMaNV();
}
