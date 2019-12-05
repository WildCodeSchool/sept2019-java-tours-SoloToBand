package com.solotoband.repository;

import com.solotoband.database.DBAccess;
import com.solotoband.entity.Groupe;
import java.sql.*;



public class GroupeRepository {
    //methode qui va appeler la connection à la DB.
    private DBAccess database = null;

    public GroupeRepository() {
        database = DBAccess.getInstance();
    }

    public boolean createGroup(Groupe groupe) {

        try {
            /**
             * fonction et commande SQL afin de générer une clef et de créer l'insert dans la DB.
             */
            PreparedStatement statement = database.getPrepareStatement(
                    "INSERT INTO groupe (group_name, contact_name, group_phone, group_email, image) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, groupe.getNameGroupe());
            statement.setString(2, groupe.getContactName());
            statement.setString(3, groupe.getGroupPhone());
            statement.setString(4, groupe.getGroupMail());
            statement.setString(5, groupe.getImage());

            // condition si l'execution de l'instruction SQL ne réussi pas.
            if (statement.executeUpdate() != 1) {
                //throw new SQLException("failed to insert data");
                return false;
            }

            // déclaration et attribution de la variable qui récupère l'id.
            ResultSet generatedKeys = statement.getGeneratedKeys();

            // Si l'on a un id, appel au constructeur afin de générer un objet groupe pour la db.
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                groupe.setId(id); // Ajout de l'id dans l'objet
                return true;
            } else {
                //throw new SQLException("failed to get inserted id");
                return false;
            }
        } catch (SQLException e) {
            return false;
        }

    }
    public Groupe findGroupeById(long id) {
        Groupe groupe = new Groupe();
        PreparedStatement requete = database.getPrepareStatement("SELECT * FROM groupe WHERE id = ?");
        if (requete == null){
            return null;
        }
        ResultSet resultat;
        try {
            requete.setLong(1, id);
            resultat = requete.executeQuery();
            if (resultat.next()){
                groupe.setId(id);
                groupe.setNameGroupe(resultat.getString("group_name"));
                groupe.setContactName(resultat.getString("contact_name"));
                groupe.setGroupPhone(resultat.getString("group_phone"));
                groupe.setGroupMail(resultat.getString("group_email"));
                groupe.setImage(resultat.getString("image"));
            }
            requete.close();
            return groupe;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}