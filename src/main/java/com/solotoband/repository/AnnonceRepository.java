package com.solotoband.repository;

import com.solotoband.database.DBAccess;
import com.solotoband.entity.Annonce;
import java.sql.*;



public class AnnonceRepository {
    // methode qui va appeler la connection à la DB.
    private static DBAccess database = null;

    public AnnonceRepository() {
        database = DBAccess.getInstance();
    }

    public static boolean createAnnonce(Annonce annonce) {
        try {
            PreparedStatement statement = database.getPrepareStatement( "INSERT INTO annonce (instrument, style, level, info, departement, groupe) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setLong(1, instrument.getId());
            statement.setLong(2, style.getId());
            statement.setString(3, annonce.getLevel());
            statement.setString(4, annonce.getInfo());
            statement.setLong(5, departement.getId());
            statement.setLong(6, groupe.getId());

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
                annonce.setId(id); // Ajout de l'id dans l'objet
                return  true;
            } else 
            {
                //throw new SQLException("failed to get inserted id");
                return false;
            }
        }
        catch (SQLException e) 
        {
            return false;
        }

    }
}