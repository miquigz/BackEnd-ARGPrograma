package com.portfolio.miquigz.Dto;

import javax.validation.constraints.NotBlank;

//DTO = Data Transfer Object
public class ExperienciaDto {
    @NotBlank
    private String nameE;
    @NotBlank
    private String descE;

//Constructors
    public ExperienciaDto() {
    }
    public ExperienciaDto(String nameE, String descE) {
        this.nameE = nameE;
        this.descE = descE;
    }

//Getters & setters
    public String getNameE() {
        return nameE;
    }
    public void setNameE(String nameE) {
        this.nameE = nameE;
    }
    public String getDescE() {
        return descE;
    }
    public void setDescE(String descE) {
        this.descE = descE;
    }
}
