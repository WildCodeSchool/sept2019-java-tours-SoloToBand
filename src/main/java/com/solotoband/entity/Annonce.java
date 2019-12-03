package com.solotoband.entity;
import javax.validation.constraints.*;

public class Annonce 
{
    // Déclaration des variables du constructeur et des validateurs
    private long id;

    @NotEmpty
    private long id_instrument;

    @NotEmpty 
    private long id_style;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    private String level;

    @NotEmpty 
    private String info;

    @NotEmpty
    private long id_departement;

    private long groupe;




    public Annonce() {
    }

    public Annonce(long id, long id_instrument, long id_style, String level, String info, long id_departement, long groupe) {
        this.id = id;
        this.id_instrument = id_instrument;
        this.id_style = id_style;
        this.level = level;
        this.info = info;
        this.id_departement = id_departement;
        this.groupe = groupe;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_instrument() {
        return this.id_instrument;
    }

    public void setId_instrument(long id_instrument) {
        this.id_instrument = id_instrument;
    }

    public long getId_style() {
        return this.id_style;
    }

    public void setId_style(long id_style) {
        this.id_style = id_style;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getId_departement() {
        return this.id_departement;
    }

    public void setId_departement(long id_departement) {
        this.id_departement = id_departement;
    }

    public long getGroupe() {
        return this.groupe;
    }

    public void setGroupe(long groupe) {
        this.groupe = groupe;
    }

   
    
    }

    