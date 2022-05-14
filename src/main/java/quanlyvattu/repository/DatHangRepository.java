package quanlyvattu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quanlyvattu.entity.DatHangEntity;

public interface DatHangRepository extends JpaRepository<DatHangEntity, String> {

	@Query("select datHang from DatHangEntity datHang where datHang.kho.maKho = ?1")
	List<DatHangEntity> findByKho(String maKho);

}
