package com.portfolio.miquigz.Security.Service;

import com.portfolio.miquigz.Security.Entity.Rol;
import com.portfolio.miquigz.Security.Enums.RolName;
import com.portfolio.miquigz.Security.Repository.InterfaceRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional //Persistencia de datos (Poder hacer rollback,etc).
public class RolService {
    @Autowired
    InterfaceRolRepository iRolRepository;

    public Optional<Rol> getByRolName(RolName rolName){
        return iRolRepository.findByRolName(rolName);
    }

    public void save(Rol rol){
        iRolRepository.save(rol);
    }


}

