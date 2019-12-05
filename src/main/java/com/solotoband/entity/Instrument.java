package com.solotoband.entity;

public class Instrument {
    private long id;
    private String name;
    private String categorie;


    public Instrument() {

    }

    public Instrument(long id, String name, String categorie) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

}