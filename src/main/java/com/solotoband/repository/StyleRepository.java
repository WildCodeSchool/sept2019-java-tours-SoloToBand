package com.solotoband.repository;

import java.sql.ResultSet;
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
}