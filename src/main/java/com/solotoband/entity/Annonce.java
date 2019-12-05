package com.solotoband.entity;

public class Annonce {
    // Déclaration des variables du constructeur et des validateurs
    private long id;
    private long id_instrument;
    private long id_style;
    private String level;
    private String info;
    private long id_departement;
    private long groupeAnnonce;
    private Departement departement;
    private Instrument instrument;
    private Style style;
    private Groupe groupe;

    public Annonce() {
    }

    public Annonce(long id, long id_instrument, long id_style, String level, String info, long id_departement,
            long groupeAnnonce) {
        this.id = id;
        this.id_instrument = id_instrument;
        this.id_style = id_style;
        this.level = level;
        this.info = info;
        this.id_departement = id_departement;
        this.groupeAnnonce = groupeAnnonce;
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

    public long getGroupeAnnonce() {
        return this.groupeAnnonce;
    }

    public void setGroupeAnnonce(long groupeAnnonce) {
        this.groupeAnnonce = groupeAnnonce;
    }

}
