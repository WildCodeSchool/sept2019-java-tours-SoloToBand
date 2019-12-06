package com.solotoband.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solotoband.database.DBAccess;
import com.solotoband.entity.Instrument;

public class InstrumentRepository {
    private DBAccess base;

    public InstrumentRepository() {
        base = DBAccess.getInstance();
    }
    /**
     * Fonction findAll qui permet de renvoyer 
     * tous les instruments stockés dans la DB
     * @return
     */
    public List<Instrument> findAll() {
        // Crétion d'un arrayList d'objets instruments
        List<Instrument> instruments = new ArrayList<>();
        Statement requete = base.getStatement();
        if (requete == null) {
            return null;
        }
        ResultSet resultats;
        try {
            resultats = requete.executeQuery("SELECT * FROM instrument ORDER BY name");
            while (resultats.next()) {
                Instrument instrument = new Instrument();
                instrument.setId(resultats.getLong("idinstrument"));
                instrument.setCategorie(resultats.getString("categorie"));
                instrument.setName(resultats.getString("name"));
                instruments.add(instrument);
            }
            requete.close();
            return instruments;

        } catch (SQLException e) {
            // on affiche la stack à affiner plus tard
            e.printStackTrace();
            return null;
        }
    }

    public boolean createInstrument(Instrument instrument){
        try {
            /**
             * fonction et commande SQL afin de générer une clef et de créer l'insert dans la DB.
             */ 
            PreparedStatement statement = base.getPrepareStatement(
                "INSERT INTO instrument(name, categorie) VALUES(?, ?)"
            );


            statement.setString(1, instrument.getName());
            statement.setString(2, instrument.getCategorie());
            // condition si l'execution de l'instruction SQL ne réussi pas.
            if (statement.executeUpdate() != 1) 
            {
                //throw new SQLException("failed to insert data");
                return false;
            }

            // déclaration et attribution de la variable qui récupère l'id.
            ResultSet generatedKeys = statement.getGeneratedKeys();

            // Si l'on a un id, appel au constructeur afin de générer un objet groupe pour la db.
            if (generatedKeys.next()) 
            {
                Long id = generatedKeys.getLong(1);
                instrument.setId(id); // Ajout de l'id dans l'objet
                return  true;
            } else 
            {
                //throw new SQLException("failed to get inserted id");
                return false;
            }
        } catch (SQLException e) 
            {
                return false;
            }
    
    }

}
