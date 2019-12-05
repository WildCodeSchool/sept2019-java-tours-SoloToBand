package com.solotoband.entity;

public class Departement {
    private long id;
    private String departement_code;
    private String departement_nom;

    public Departement() {

    }

    public Departement(long id, String code, String name) {
        this.id = id;
        this.departement_code = code;
        this.departement_nom = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartement_code() {
        return this.departement_code;
    }

    public void setDepartement_code(String departement_code) {
        this.departement_code = departement_code;
    }

    public String getDepartement_nom() {
        return this.departement_nom;
    }

    public void setDepartement_nom(String departement_nom) {
        this.departement_nom = departement_nom;
    }
}
