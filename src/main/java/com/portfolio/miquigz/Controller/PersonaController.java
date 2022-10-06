/**** @author miqui */
package com.portfolio.miquigz.Controller;

import com.portfolio.miquigz.Interface.InterfacePersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.miquigz.Entity.Persona;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PersonaController {
    @Autowired InterfacePersonaService ipersonaService;

    //asigno esta url/endpoint al metodo getPersona. (GET)
    @GetMapping("personas/traer") // de la DB al front(resumidamente).
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    //asigno esta url al metodo POST createPersona
    @PostMapping("personas/crear")//Front a la DB
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);//Utilizamos metodo save, y guardamos el request
        return "Persona creada y guardada en la database";// + "\n" + persona
    }
    //endpoint {id} :id , id a borrar(persona).
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "Persona borrada, con id:" + id;
    }
    
    //Editar persona, {id} :id
    @PutMapping("personas/editar/:id")
    public Persona editPersona(@PathVariable Long id, //ID a ser cambiada/editada
            @RequestParam("name") String newName,//dato a cambiar por la variable newName
            @RequestParam("lastName") String newLastName,
            @RequestParam("image") String newImage) {
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setName(newName);
        persona.setLastName(newLastName);
        persona.setImage(newImage);
        ipersonaService.savePersona(persona); //guardamos la variable persona, (con los nuevos valores).
        return persona;
    }
    
}
