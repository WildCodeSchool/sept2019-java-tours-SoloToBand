package com.solotoband.repository;

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

    public List<Instrument> findAll() {
        ArrayList<Instrument> instruments = new ArrayList<>();
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

}
