package quanlyvattu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlyvattu.entity.DatHangEntity;



public interface DatHangRepository extends JpaRepository<DatHangEntity, String> {
	
}
