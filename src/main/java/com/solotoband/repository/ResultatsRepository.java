package com.solotoband.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solotoband.database.DBAccess;
import com.solotoband.entity.Annonce;
import com.solotoband.entity.Departement;
import com.solotoband.entity.Groupe;
import com.solotoband.entity.Instrument;
import com.solotoband.entity.Style;

public class ResultatsRepository {
    private static DBAccess database = null;

    public ResultatsRepository() {
        database = DBAccess.getInstance();
    }

    public List<Annonce> getAnnonceByQuery(long instrument, long style, long departement, String level) {


        PreparedStatement requete;

        List<Annonce> annoncesGroupes = new ArrayList<>();



        try {
            requete = database.getPrepareStatement(
                    "SELECT * FROM annonce JOIN instrument ON annonce.instrument=instrument.idinstrument"
                            + " JOIN style ON annonce.style=style.id JOIN departement ON annonce.departement=departement.id"
                            + " JOIN groupe ON annonce.groupe = groupe.id "
                            + " WHERE annonce.instrument=? AND annonce.style=? AND annonce.departement=? AND annonce.level=?");

            requete.setLong(1, instrument);
            requete.setLong(2, style);
            requete.setLong(3, departement);
            requete.setString(4, level);
            ResultSet resultSet = requete.executeQuery();
            

            while (resultSet.next()) {

                Annonce tmpAnnonce = new Annonce();

                Departement departementObj = new Departement();
                departementObj.setId(resultSet.getLong("departement.id"));
                departementObj.setDepartement_code(resultSet.getString("departement.departement_code"));
                departementObj.setDepartement_nom(resultSet.getString("departement.departement_nom"));
                tmpAnnonce.setDepartement(departementObj);

                Instrument instrumentObj = new Instrument();
                instrumentObj.setId(resultSet.getLong("instrument.idinstrument"));
                instrumentObj.setName(resultSet.getString("instrument.name"));
                instrumentObj.setCategorie(resultSet.getString("instrument.categorie"));
                tmpAnnonce.setInstrument(instrumentObj);

                Style styleObj = new Style();
                styleObj.setId(resultSet.getLong("style.id"));
                styleObj.setName_style(resultSet.getString("style.name_style"));
                styleObj.setCourant(resultSet.getString("style.courant"));
                tmpAnnonce.setStyle(styleObj);

                Groupe groupeObj = new Groupe();
                groupeObj.setId(resultSet.getLong("groupe.id"));
                groupeObj.setNameGroupe(resultSet.getString("groupe.group_name"));
                groupeObj.setContactName(resultSet.getString("groupe.contact_name"));
                groupeObj.setGroupPhone(resultSet.getString("groupe.group_phone"));
                groupeObj.setGroupMail(resultSet.getString("groupe.group_email"));
                groupeObj.setImage(resultSet.getString("groupe.image"));
                tmpAnnonce.setGroupe(groupeObj);

                tmpAnnonce.setGroupeAnnonce(resultSet.getLong("groupe"));
                tmpAnnonce.setId(resultSet.getLong("id"));
                tmpAnnonce.setId_departement(resultSet.getLong("departement"));
                tmpAnnonce.setId_instrument(resultSet.getLong("instrument"));
                tmpAnnonce.setId_style(resultSet.getLong("style"));
                tmpAnnonce.setInfo(resultSet.getString("annonce.info"));
                tmpAnnonce.setLevel(resultSet.getString("annonce.level"));
                annoncesGroupes.add(tmpAnnonce);

            }
            return annoncesGroupes;
        } catch (SQLException e) {
            e.printStackTrace();
            return annoncesGroupes;
        }
    }

}