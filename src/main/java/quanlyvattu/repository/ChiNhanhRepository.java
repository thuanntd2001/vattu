package quanlyvattu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlyvattu.entity.ChiNhanhEntity;
import quanlyvattu.entity.NhanVienEntity;



public interface ChiNhanhRepository extends JpaRepository<ChiNhanhEntity, String> {
	
}
