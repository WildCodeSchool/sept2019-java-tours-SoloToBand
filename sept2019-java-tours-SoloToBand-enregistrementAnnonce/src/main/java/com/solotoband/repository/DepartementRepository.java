package com.solotoband.repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.solotoband.database.DBAccess;
import com.solotoband.entity.Departement;

public class DepartementRepository {
    private DBAccess base;

    public DepartementRepository() {
        base = DBAccess.getInstance();
    }

    public ArrayList<Departement> findAll() {

        ArrayList<Departement> departements = new ArrayList<>();
        Statement requete = base.getStatement();
        if (requete == null) {
            return null;
        }
        ResultSet resultats;
        try {
            resultats = requete.executeQuery("SELECT * FROM departement");
            while (resultats.next()) {
                Departement departement = new Departement();
                departement.setId(resultats.getLong("id"));
                departement.setDepartement_code(resultats.getString("departement_code"));
                departement.setDepartement_nom(resultats.getString("departement_nom"));
                departements.add(departement);
            }
            requete.close();
            return departements;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

}