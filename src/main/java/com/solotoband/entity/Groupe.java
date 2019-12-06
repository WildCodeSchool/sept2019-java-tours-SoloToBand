package com.solotoband.entity;

import javax.validation.constraints.*;

public class Groupe {
    // Déclaration des variables du constructeur et des validateurs
    private Long id;
    @NotEmpty
    @Size(min = 1, max = 50, message = "Nom trop grand")
    private String nameGroupe;

    @NotEmpty
    @Size(min = 1, max = 50, message = "Nom trop grand")
    @Pattern(regexp = "^[a-zéèàûê' .A-Z0-9]*$", message = "Vous nom ne doit comporter que des lettres ou des chiffres")
    private String contactName;

    @NotEmpty
    @Pattern(regexp = "^[0-9]*$", message = "Le numéro de telephone ne comporter que des chiffres")
    @Size(min = 10, max = 10, message = "Votre numéro doit comporter 10 chiffres")
    private String groupPhone;

    @NotEmpty
    @Pattern(regexp = "^[a-z-+.@A-Z0-9]*$", message = "Vous utilisez des caractères non valides")
    private String groupMail;

    
    private String image;

    // Constructeurs du groupe
    public Groupe() {

    }

    public Groupe(Long id, String nameGroupe, String contactName, String groupPhone, String groupMail, String image) {
        this.id = id;
        this.nameGroupe = nameGroupe;
        this.contactName = contactName;
        this.groupPhone = groupPhone;
        this.groupMail = groupMail;
        this.image = image;
    }

    // Getters et setters

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGroupe() {
        return this.nameGroupe;
    }

    public void setNameGroupe(String nameGroupe) {
        this.nameGroupe = nameGroupe;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getGroupPhone() {
        return this.groupPhone;
    }

    public void setGroupPhone(String groupPhone) {
        this.groupPhone = groupPhone;
    }

    public String getGroupMail() {
        return this.groupMail;
    }

    public void setGroupMail(String groupMail) {
        this.groupMail = groupMail;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}