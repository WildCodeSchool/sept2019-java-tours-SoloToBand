package com.solotoband.database;

// Import SQLconnection pour pouvoir acces aux methodes.
import java.sql.*;
import java.util.Properties;

public class DBAccess {
    private Connection connection = null;

    private static DBAccess instance = null;

    /**
     * Methode de classe servant à récupérer l'unique instance de DBAccess
     * 
     * @return DBAccess
     */
    public static DBAccess getInstance() {
        if (instance == null) {
            instance = new DBAccess();
        }
        return instance;
    }

    /**
     * constructeur de la class DBAccess privé pour empécher la construction en
     * dehors de la classe car on souhaite une seul instance pour récupérer cette
     * instance il faut utiliser la méthode getInstance()
     * 
     */
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

    /**
     * methode permettant la création d'une nouvelle requete avec la connexion
     * courante en cas de probleme, par exemple si la connexion n'est pas ouverte,
     * return null.
     * 
     * @return Statement nouvelle requête ou null en cas de problème
     *
     */
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

    // methode préparation de requête sur une connection ouverte.
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