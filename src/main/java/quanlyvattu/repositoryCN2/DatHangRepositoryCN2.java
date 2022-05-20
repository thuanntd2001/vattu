package quanlyvattu.repositoryCN2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quanlyvattu.entity.DatHangEntity;

public interface DatHangRepositoryCN2 extends JpaRepository<DatHangEntity, String> {

	@Query("select datHang from DatHangEntity datHang where datHang.kho.maKho = ?1")
	List<DatHangEntity> findByKho(String maKho);

}