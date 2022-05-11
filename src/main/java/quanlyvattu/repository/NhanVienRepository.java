package quanlyvattu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlyvattu.entity.NhanVienEntity;



public interface NhanVienRepository extends JpaRepository<NhanVienEntity, String> {
	
}
