package quanlyvattu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlyvattu.entity.PhieuXuatEntity;

public interface VatTuRepository extends JpaRepository<PhieuXuatEntity, String> {

}
