package com.portfolio.miquigz.Repository;

import com.portfolio.miquigz.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Methods jpaRepository heredados, (Ctrl + click in JpaRepo..)
@Repository//Interface hereda de:     //Clase a importar, y el tipo de dato de la primary key
public interface InterfacePersonaRepository extends JpaRepository<Persona, Long>{
    
}
