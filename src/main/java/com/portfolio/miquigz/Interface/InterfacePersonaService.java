package com.portfolio.miquigz.Interface;

import com.portfolio.miquigz.Entity.Persona;
import java.util.List;

/** ** @author mique*/
public interface InterfacePersonaService {
    //List of Persona class
    public List<Persona> getPersona();
    
    //Guardar obj tipo Persona
    public void savePersona(Persona persona);
    //borrar persona
    public void deletePersona(Long id);
    //buscar persona
    public Persona findPersona(Long id);
}
