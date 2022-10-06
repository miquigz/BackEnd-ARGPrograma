package com.portfolio.miquigz.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 6, max = 45, message = "Longitud de caracteres invalida")
    private String name;
    
    @NotNull
    @Size(min = 6, max = 45, message = "Longitud de caracteres invalida")
    private String lastName;
    
    @Size(min = 6, max = 100, message = "Longitud de caracteres invalida")
    private String image;
    
    
}
