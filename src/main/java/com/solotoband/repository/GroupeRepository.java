package com.solotoband.repository;

import com.solotoband.entity.Groupe;

import java.sql.*;

public class GroupeRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/solotoband?serverTimezone=GMT";
    private final static String DB_USER = "soloman";
    private final static String DB_PASSWORD = "annsolo";

    // Fonction save qui prend en paramètre les attribus du constructeur
    public Groupe save(String nameGroupe, String contactName, 
    Long groupPhone, String groupMail, String groupInfo, String instrument, 
    String musicFlux, String level, Long departement) 
    {
        // Connection à la DB grâce aux indentifiants de l'user crée
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );

            // fonction et commande SQL afin de générer une clef et de créer l'insert dans la DB.
            PreparedStatement statement = connection.prepareStatement
            (
                "INSERT INTO groupe (group_name, contact_name, group_phone, group_email, group_info, instrument, music_flux, level, departement) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, nameGroupe);
            statement.setString(2, contactName);
            statement.setLong(3, groupPhone);
            statement.setString(4,groupMail);
            statement.setString(5, groupInfo);
            statement.setString(6, instrument);
            statement.setString(7, musicFlux);
            statement.setString(8, level);
            statement.setLong(9, departement); // 1h de recherche sur ce parametre 9...

            // condition si l'execution de l'instruction SQL ne réussi pas.
            if (statement.executeUpdate() != 1) 
            {
                throw new SQLException("failed to insert data");
            }

            // déclaration et attribution de la variable qui récupère l'id.
            ResultSet generatedKeys = statement.getGeneratedKeys();

            // Si l'on a un id, appel au constructeur afin de générer un objet groupe.
            if (generatedKeys.next()) 
            {
                Long id = generatedKeys.getLong(1);
                return new Groupe(id, nameGroupe, contactName, groupPhone, groupMail,
                        groupInfo, instrument, musicFlux, level, departement);
            } else 
            {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        return null;
    }
}