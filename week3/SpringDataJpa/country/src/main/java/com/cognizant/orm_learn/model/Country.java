package com.cognizant.orm_learn.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country{
    @Id
    @Column(name="code")
    private String Code;

    @Column(name="name")
    private String name;

    public Country(){}
    public Country(String code, String name){
        this.Code = code;
        this.name = name;
    }
    public String getCode() {
        return Code;
    }
    public void setCode(String code) {
        Code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Country{" + "Code=" + Code + ", name=" + name + '}';
    }
}
