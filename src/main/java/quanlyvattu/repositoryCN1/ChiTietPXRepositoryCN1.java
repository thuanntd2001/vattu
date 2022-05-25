package quanlyvattu.repositoryCN1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quanlyvattu.entity.CTPXEntity;





public interface ChiTietPXRepositoryCN1 extends JpaRepository<CTPXEntity, String> {

	@Query("select ctPhieuxuat from CTPXEntity ctPhieuxuat where ctPhieuxuat.phieuXuat.maPX = ?1")
	List<CTPXEntity> findByMaSoPX(String maSoDDH);

}
