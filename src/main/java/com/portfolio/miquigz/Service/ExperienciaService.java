package com.portfolio.miquigz.Service;

import com.portfolio.miquigz.Entity.Experiencia;
import com.portfolio.miquigz.Repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional //Persistencia
public class ExperienciaService {
    @Autowired//inyectar repository
    ExperienciaRepository experienciaRepository;

    public List<Experiencia> list(){
        return experienciaRepository.findAll();//List de todas las listas de exp(encontradas).
    }

    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }
    public Optional<Experiencia> getByNameE(String nameE){
        return experienciaRepository.findByNameE(nameE);
    }
    //save obj
    public void save(Experiencia experiencia){
        experienciaRepository.save(experiencia);
    }

    public void delete(int id){
        experienciaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }
    public boolean existsByNameE(String nameE){
        return experienciaRepository.existsByNameE(nameE);
    }
}
