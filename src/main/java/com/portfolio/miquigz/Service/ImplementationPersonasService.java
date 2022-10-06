package com.portfolio.miquigz.Service;

import com.portfolio.miquigz.Entity.Persona;
import com.portfolio.miquigz.Interface.InterfacePersonaService;
import com.portfolio.miquigz.Repository.InterfacePersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementationPersonasService implements InterfacePersonaService {
//inyectar dependencias dentro de otras con: AutoWired (Spring)
    @Autowired InterfacePersonaRepository iPersonaRepository;
        
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;  //SI no encuentra persona, entonces devuelvo null(.orElse(null))
    }
 
}
