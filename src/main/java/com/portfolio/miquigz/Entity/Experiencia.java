package com.portfolio.miquigz.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameE;
    private String descE;

    /*
    private String img;
    private String altImg;*/


    //Constructors
    public Experiencia() {
    }

    public Experiencia(String nameE, String descE) {
        this.nameE = nameE;
        this.descE = descE;
    }

//getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
