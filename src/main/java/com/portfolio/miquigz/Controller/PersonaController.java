/**** @author miqui */
package com.portfolio.miquigz.Controller;

import com.portfolio.miquigz.Interface.InterfacePersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.portfolio.miquigz.Entity.Persona;

@RestController
@CrossOrigin(origins = "http://localhost:4200") //haremos llamados desde esta URL (Angular, modo desarrollo)
public class PersonaController {
    @Autowired InterfacePersonaService ipersonaService;

    //------------- GET
    //asigno esta url/endpoint al metodo getPersona. (GET)
    @GetMapping("personas/traer") // de la DB al front(resumidamente).
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }

    @GetMapping("personas/traer/{id}")
    public Persona getPersona(@PathVariable Long id){
        return ipersonaService.findPersona(id);
    }


    //------------- POST
    @PreAuthorize("hasRole('ADMIN')") //Solo el ROL ADMIN podra usar este endpoint POST
    @PostMapping("personas/crear")//Front a la DB
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);//Utilizamos metodo save, y guardamos el request
        return "Persona creada y guardada en la database";// + "\n" + persona
    }

    //------------- DELETE
    //endpoint {id} :id , id a borrar(persona).
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "Persona borrada, con id:" + id;
    }


    //------------- EDIT
    //Editar persona, {id} :id
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/{id}")
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
