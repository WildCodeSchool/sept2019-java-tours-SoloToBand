package com.solotoband.entity;

public class Style {
    private Long id;
    private String name_style;
    private String courant;

    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_style() {
        return this.name_style;
    }

    public void setName_style(String name_style) {
        this.name_style = name_style;
    }

    public String getCourant() {
        return this.courant;
    }

    public void setCourant(String courant) {
        this.courant = courant;
    }

}
