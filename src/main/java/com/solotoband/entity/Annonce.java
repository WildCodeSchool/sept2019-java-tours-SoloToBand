package com.solotoband.entity;
import javax.validation.constraints.*;

public class Annonce 
{
    // Déclaration des variables du constructeur et des validateurs
    private long id;

    @NotEmpty
    private long instrument;

    @NotEmpty 
    private long style;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    private String level;

    @NotEmpty 
    private String info;

    @NotEmpty
    private long departement;

    private long groupe;



    public Annonce() {
    }

    public Annonce(long id, long instrument, long style, String level, String info, long departement, long groupe) {
        this.id = id;
        this.instrument = instrument;
        this.style = style;
        this.level = level;
        this.info = info;
        this.departement = departement;
        this.groupe = groupe;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInstrument() {
        return this.instrument;
    }

    public void setInstrument(long instrument) {
        this.instrument = instrument;
    }

    public long getStyle() {
        return this.style;
    }

    public void setStyle(long style) {
        this.style = style;
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

    public long getDepartement() {
        return this.departement;
    }

    public void setDepartement(long departement) {
        this.departement = departement;
    }

    public long getGroupe() {
        return this.groupe;
    }

    public void setGroupe(long groupe) {
        this.groupe = groupe;
    }

    
}
    