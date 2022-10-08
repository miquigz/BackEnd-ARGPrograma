package com.portfolio.miquigz.Repository;

import com.portfolio.miquigz.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNameE(String nameE);
    public boolean existsByNameE(String userE);

}
