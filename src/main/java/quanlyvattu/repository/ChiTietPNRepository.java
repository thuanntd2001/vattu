package quanlyvattu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quanlyvattu.entity.CTPNEntity;






public interface ChiTietPNRepository extends JpaRepository<CTPNEntity, String> {

	@Query("select ctPhieunhap from CTPNEntity ctPhieunhap where ctPhieunhap.phieuNhap.maPN = ?1")
	List<CTPNEntity> findByMaSoPN(String maSoDDH);

}
