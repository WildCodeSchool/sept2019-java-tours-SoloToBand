package com.solotoband.entity;

public class Annonce {
    // Déclaration des variables du constructeur et des validateurs
    private long id;


    
    private long idInstrument;

    private long idStyle;

    private String level;
    private String info;

    private Departement departement;
    private Instrument instrument;
    private Style style;
    private Groupe groupe;
    
    private long idDepartement;

    private long idGroupe;





    public Annonce() {
    }

    public Annonce(long id, long idInstrument, long idStyle, String level, String info, long idDepartement, long idGroupe) {
        this.id = id;
        this.idInstrument = idInstrument;
        this.idStyle = idStyle;
        this.level = level;
        this.info = info;
        this.idDepartement = idDepartement;
        this.idGroupe = idGroupe;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }




    public Groupe getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public long getIdInstrument() {
        return this.idInstrument;
    }

    public void setIdInstrument(long idInstrument) {
        this.idInstrument = idInstrument;
    }

    public long getIdStyle() {
        return this.idStyle;
    }

    public void setIdStyle(long idStyle) {
        this.idStyle = idStyle;

    }

    public Style getStyle() {
        return this.style;
    }

    public void setStyle(Style sty) {
        this.style = sty;
    }

    public Instrument getInstrument() {
        return this.instrument;
    }

    public void setInstrument(Instrument inst) {
        this.instrument = inst;
    }


    public Departement getDepartement() {
        return this.departement;
    }

    public void setDepartement(Departement dep) {
        this.departement = dep;
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

    



    public long getIdDepartement() {
        return this.idDepartement;
    }

    public void setIdDepartement(long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public long getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(long idGroupe) {
        this.idGroupe = idGroupe;
    }

    
}

    
