package quanlyvattu.repositoryCN2;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlyvattu.entity.ChiNhanhEntity;
import quanlyvattu.entity.KhoEntity;
import quanlyvattu.entity.NhanVienEntity;



public interface KhoRepositoryCN2 extends JpaRepository<KhoEntity, String> {
	
}
