package quanlyvattu.repositoryCN2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quanlyvattu.entity.DatHangEntity;
import quanlyvattu.entity.PhieuXuatEntity;
import quanlyvattu.entity.VatTuEntity;

public interface PhieuXuatRepository extends JpaRepository<PhieuXuatEntity, String> {
	@Query("select phieuXuat from PhieuXuatEntity phieuXuat where phieuXuat.kho.maKho = ?1")
	List<PhieuXuatEntity> findByKho(String maKho);

}
