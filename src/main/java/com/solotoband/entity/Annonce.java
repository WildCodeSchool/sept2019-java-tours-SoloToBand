package com.solotoband.entity;
import javax.validation.constraints.*;

public class Annonce 
{
    // Déclaration des variables du constructeur et des validateurs
    private Long id;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    private String instrument;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")  
    private String style;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    private String level;

    @NotEmpty 
    private String info;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    private String departement;

    private Long groupe;


    public Annonce() {
    }

    public Annonce(Long id, String instrument, String style, String level, String info, String departement, Long groupe) {
        this.id = id;
        this.instrument = instrument;
        this.style = style;
        this.level = level;
        this.info = info;
        this.departement = departement;
        this.groupe = groupe;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrument() {
        return this.instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
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

    public String getDepartement() {
        return this.departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Long getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Long groupe) {
        this.groupe = groupe;
    }

    public Annonce id(Long id) {
        this.id = id;
        return this;
    }

    public Annonce instrument(String instrument) {
        this.instrument = instrument;
        return this;
    }

    public Annonce style(String style) {
        this.style = style;
        return this;
    }

    public Annonce level(String level) {
        this.level = level;
        return this;
    }

    public Annonce info(String info) {
        this.info = info;
        return this;
    }

    public Annonce departement(String departement) {
        this.departement = departement;
        return this;
    }

    public Annonce groupe(Long groupe) {
        this.groupe = groupe;
        return this;
    }
}

    

   