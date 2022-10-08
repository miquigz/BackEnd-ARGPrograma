package com.portfolio.miquigz.Controller;


import com.portfolio.miquigz.Dto.ExperienciaDto;
import com.portfolio.miquigz.Entity.Experiencia;
import com.portfolio.miquigz.Security.Controller.Mensaje;
import com.portfolio.miquigz.Service.ExperienciaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // <?>  puede recibir cualquier dato
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto expDto){
        if(StringUtils.isBlank(expDto.getNameE()))
                return new ResponseEntity(new Mensaje("Error: Nombre obligatorio!"), HttpStatus.BAD_REQUEST);
        if (experienciaService.existsByNameE(expDto.getNameE()))
            return new ResponseEntity(new Mensaje("Experiencia ya existente"), HttpStatus.BAD_REQUEST);

        Experiencia exp = new Experiencia(expDto.getNameE(), expDto.getDescE());
        experienciaService.save(exp);
        return new ResponseEntity(new Mensaje("Experiencia Agregada correctamente"), HttpStatus.OK);
    }

    //Actualizar datos
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto expDto){
        //Si id NO(!) existe:
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);

        //Comparamos nombre de experiencias
        if (experienciaService.existsByNameE(expDto.getNameE()) &&
                experienciaService.getByNameE(expDto.getNameE()).get().getId() != id )
            return new ResponseEntity(new Mensaje("Experiencia ya existente"),HttpStatus.BAD_REQUEST);

        if (StringUtils.isBlank(expDto.getNameE()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio!"), HttpStatus.BAD_REQUEST);

        Experiencia exp = experienciaService.getOne(id).get();
        exp.setNameE(expDto.getNameE());
        exp.setDescE(expDto.getDescE());
        experienciaService.save(exp);
        return new ResponseEntity(new Mensaje("EXPERIENCIA ACTUALIZADA(EDITADA)"), HttpStatus.OK);
    }

    //<?> = tipo any
    public ResponseEntity<?> delete(@PathVariable("id") int id, @RequestBody ExperienciaDto expDto){
        //Si id NO(!) existe:
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);

        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("EXPERIENCIA BORRADA"), HttpStatus.OK);
    }
}
