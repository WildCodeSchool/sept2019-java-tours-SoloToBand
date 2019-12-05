package com.solotoband.database;

// Import SQLconnection pour pouvoir acces aux methodes.
import java.sql.*;
import java.util.Properties;

public class DBAccess {
    private Connection connection = null;

    private static DBAccess instance = null;
    
    // fonction  (a revoir).
    public static DBAccess getInstance() {
        if (instance == null) {
            instance =  new DBAccess();
        }
        return instance;
    }

    // créer une methode qui configure notre connection à la DB (attribut null si connection echoue)
    private DBAccess() {
        Properties config = new Properties();
        config.setProperty("user", DBConfig.USER);
        config.setProperty("password", DBConfig.PASSWORD);
           
        try {
            connection = DriverManager.getConnection(DBConfig.URL, config);

        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    //methode du Statement sur une connection ouverte.
    public Statement getStatement() {
        Statement request = null;
        if (connection == null) {
            return null;
        }
        try {
            request = connection.createStatement();
            return request;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //methode préparation de requête sur une connection ouverte.
    public PreparedStatement getPrepareStatement(String sqlCommand) {
        PreparedStatement request = null;
        if (connection == null) {
            return null;
        }
        try {
            request = connection.prepareStatement(sqlCommand, Statement.RETURN_GENERATED_KEYS);
            return request;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}