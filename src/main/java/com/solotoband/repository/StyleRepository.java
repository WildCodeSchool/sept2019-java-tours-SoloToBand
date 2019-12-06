package com.solotoband.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solotoband.database.DBAccess;
import com.solotoband.entity.Style;

public class StyleRepository {
    private DBAccess base;

    public StyleRepository() {
        base = DBAccess.getInstance();

    }

    public List<Style> findAll() {

        List<Style> styles = new ArrayList<>();
        Statement requete = base.getStatement();
        if (requete == null) {
            return null;
        }
        ResultSet resultats;
        try {
            resultats = requete.executeQuery("SELECT * FROM style ORDER BY name_style");
            while (resultats.next()) {
                Style style = new Style();
                style.setId(resultats.getLong("id"));
                style.setName_style(resultats.getString("name_style"));
                style.setCourant(resultats.getString("courant"));
                styles.add(style);

            }
            requete.close();
            return styles;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }

    public boolean createStyle(Style style){
        try {
            /**
             * fonction et commande SQL afin de générer une clef et de créer l'insert dans la DB.
             */ 
            PreparedStatement statement = base.getPrepareStatement(
                "INSERT INTO style(name_style, courant) VALUES(?, ?)"
            );


            statement.setString(1, style.getName_style());
            statement.setString(2, style.getCourant());
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
                style.setId(id); // Ajout de l'id dans l'objet
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