package com.portfolio.miquigz.Security.Entity;

import com.portfolio.miquigz.Security.Enums.RolName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING) //valores a ingresar de tipo string
    private RolName rolName;

    //Constructores
    public Rol() {
    }
    public Rol(RolName rolName) {
        this.rolName = rolName;
    }
    //Getters
    public RolName getRolName() {
        return rolName;
    }
    public int getId() {
        return id;}
    //Setters
    public void setRolName(RolName rolName) {
        this.rolName = rolName;}
    public void setId(int id) {
        this.id = id;}


}
