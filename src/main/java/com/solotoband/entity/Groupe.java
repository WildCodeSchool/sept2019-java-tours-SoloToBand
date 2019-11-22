package com.solotoband.entity;
import javax.validation.constraints.*;

public class Groupe 
{
    // Déclaration des variables du constructeur
    private Long id;
    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    @Pattern(regexp = "^[a-zéèà'.A-Z0-9]*$", message="Le nom ne doit pas comporter de caractères spéciaux")
    private String nameGroupe;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    @Pattern(regexp = "^[a-zéèà'.A-Z0-9]*$", message="Vous nom ne doit comporter que des lettres ou des chiffres")    
    private String contactName;

    @NotEmpty
    @Pattern(regexp = "^[0-9]*$", message="Le numéro de telephone ne comporter que des chiffres")
    @Size(min=10, max= 10, message="Votre numéro doit comporter 10 chiffres")
    private String groupPhone;

    @NotEmpty
    @Pattern(regexp = "^[a-z-.@A-Z0-9]*$", message="Vous utilisez des caractères non valides")    
    private String groupMail;

    @NotEmpty
    @Pattern(regexp = "^[a-z-.A-Z0-9]*$", message="Vous utilisez des caractères non valides. Les valides sont(des lettres @ _ - . des chiffres)")
    private String groupInfo;

    @NotEmpty
    @Pattern(regexp = "^[a-z-.A-Z0-9]*$", message="Vous utilisez des caractères non valides")
    private String instrument;

    @NotEmpty
    @Size(min=1, max= 50, message="Nom trop grand")
    @Pattern(regexp = "^[a-z-.A-Z]*$", message="Vous utilisez des caractères non valides")    
    private String musicFlux;

    @NotEmpty
    private String level;

    @NotNull
    private Long departement;

    // Constructeur du groupe
    public Groupe(){

    }

    public Groupe(Long id, String nameGroupe, String contactName, 
    String groupPhone, String groupMail, String groupInfo, String instrument, 
    String musicFlux, String level, Long departement) 
    {
        this.id = id;
        this.nameGroupe = nameGroupe;
        this.contactName = contactName;
        this.groupPhone = groupPhone;
        this.groupMail = groupMail;
        this.groupInfo = groupInfo;
        this.instrument = instrument;
        this.musicFlux = musicFlux;
        this.level = level;
        this.departement = departement;
    }

    // Getters et setters
    
    public Long getId() 
    {
        return this.id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getNameGroupe() 
    {
        return this.nameGroupe;
    }

    public void setNameGroupe(String nameGroupe) 
    {
        this.nameGroupe = nameGroupe;
    }

    public String getContactName() 
    {
        return this.contactName;
    }

    public void setContactName(String contactName) 
    {
        this.contactName = contactName;
    }

    public String getGroupPhone() 
    {
        return this.groupPhone;
    }

    public void setGroupPhone(String groupPhone) 
    {
        this.groupPhone = groupPhone;
    }

    public String getGroupMail() 
    {
        return this.groupMail;
    }

    public void setGroupMail(String groupMail) 
    {
        this.groupMail = groupMail;
    }

    public String getGroupInfo() 
    {
        return this.groupInfo;
    }

    public void setGroupInfo(String groupInfo) 
    {
        this.groupInfo = groupInfo;
    }

    public String getInstrument() 
    {
        return this.instrument;
    }

    public void setInstrument(String instrument) 
    {
        this.instrument = instrument;
    }

    public String getMusicFlux() 
    {
        return this.musicFlux;
    }

    public void setMusicFlux(String musicFlux) 
    {
        this.musicFlux = musicFlux;
    }

    public String getLevel() 
    {
        return this.level;
    }

    public void setLevel(String level) 
    {
        this.level = level;
    }

    public Long getDepartement() 
    {
        return this.departement;
    }

    public void setDepartement(Long departement) 
    {
        this.departement = departement;
    }

    public Groupe id(Long id) 
    {
        this.id = id;
        return this;
    }

    public Groupe nameGroupe(String nameGroupe) 
    {
        this.nameGroupe = nameGroupe;
        return this;
    }

    public Groupe contactName(String contactName) 
    {
        this.contactName = contactName;
        return this;
    }

    public Groupe groupPhone(String groupPhone) 
    {
        this.groupPhone = groupPhone;
        return this;
    }

    public Groupe groupMail(String groupMail) 
    {
        this.groupMail = groupMail;
        return this;
    }

    public Groupe groupInfo(String groupInfo) 
    {
        this.groupInfo = groupInfo;
        return this;
    }

    public Groupe instrument(String instrument) 
    {
        this.instrument = instrument;
        return this;
    }

    public Groupe musicFlux(String musicFlux) 
    {
        this.musicFlux = musicFlux;
        return this;
    }

    public Groupe level(String level) 
    {
        this.level = level;
        return this;
    }

    public Groupe departement(Long departement) 
    {
        this.departement = departement;
        return this;
    }

}