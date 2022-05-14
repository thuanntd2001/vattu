package quanlyvattu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlyvattu.entity.ChiNhanhEntity;
import quanlyvattu.entity.KhoEntity;
import quanlyvattu.entity.NhanVienEntity;



public interface KhoRepository extends JpaRepository<KhoEntity, String> {
	
}
