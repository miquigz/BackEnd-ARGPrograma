package com.portfolio.miquigz.Security.Repository;

import com.portfolio.miquigz.Security.Entity.Rol;
import com.portfolio.miquigz.Security.Enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterfaceRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolName rolName);
}
