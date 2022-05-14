package quanlyvattu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quanlyvattu.entity.VatTuEntity;

public interface VatTuRepository extends JpaRepository<VatTuEntity, String> {

}
