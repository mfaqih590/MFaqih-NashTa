package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Nilai;

@Repository
public interface NilaiRepository extends JpaRepository<Nilai, Long> {
	Nilai findOneByIdmahasiswaAndIdmatkul(long idmahasiswa, long idmatkul);

}