package com.solotoband.repository;

import com.solotoband.entity.Groupe;

import java.sql.*;

public class GroupeRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/solotoband?serverTimezone=GMT";
    private final static String DB_USER = "soloman";
    private final static String DB_PASSWORD = "annsolo";

    // Fonction save qui prend en paramètre les attribus du constructeur
    public static boolean createGroup(Groupe groupe) 
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

            statement.setString(1, groupe.getNameGroupe());
            statement.setString(2, groupe.getContactName());
            statement.setString(3, groupe.getGroupPhone());
            statement.setString(4, groupe.getGroupMail());
            statement.setString(5, groupe.getGroupInfo());
            statement.setString(6, groupe.getInstrument());
            statement.setString(7, groupe.getMusicFlux());
            statement.setString(8, groupe.getLevel());
            statement.setString(9, groupe.getDepartement());

            // condition si l'execution de l'instruction SQL ne réussi pas.
            if (statement.executeUpdate() != 1) 
            {
                
                return false;
            }

            // déclaration et attribution de la variable qui récupère l'id.
            ResultSet generatedKeys = statement.getGeneratedKeys();

            // Si l'on a un id, appel au constructeur afin de générer un objet groupe pour la db.
            if (generatedKeys.next()) 
            {
                Long id = generatedKeys.getLong(1);
                groupe.setId(id); // Ajout de l'id dans l'objet
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
