package com.solotoband.entity;

public class Groupe 
{
    // Déclaration des variables du constructeur
    private Long id;
    private String nameGroupe;
    private String contactName;
    private Long groupPhone;
    private String groupMail;
    private String groupInfo;
    private String instrument;
    private String musicFlux;
    private String level;
    private Long departement;

    // Constructeur du groupe
    public Groupe(Long id, String nameGroupe, String contactName, 
    Long groupPhone, String groupMail, String groupInfo, String instrument, 
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

    public Long getGroupPhone() 
    {
        return this.groupPhone;
    }

    public void setGroupPhone(Long groupPhone) 
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

    public Groupe groupPhone(Long groupPhone) 
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