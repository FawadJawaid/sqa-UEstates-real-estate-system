/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsalan
 */
public class DAL {

    PreparedStatement statement = null;
    Connection con = null;

    /**
     * Function to establish connection with database
     *
     * @param dbName
     * @param id
     * @param pass
     * @return
     */
    public boolean setUpConnection(String dbName, String id, String pass) {
        boolean connectionEstablished = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, id, pass);
            connectionEstablished = true;
        } catch (Exception ex) {
            connectionEstablished = false;
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connectionEstablished;
    }

    /**
     * Function to execute create statements i.e Create, Update
     *
     * @param sql
     * @return
     */
    public boolean createStatement(String sql) {
        boolean executed = false;
        try {
            statement = con.prepareStatement(sql);
            statement.execute();
            executed = true;
        } catch (Exception ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executed;
    }

    /**
     * Function to execute create statements i.e Create, Update for dates
     *
     * @param sql
     * @return
     */
    public boolean createStatement(String sql, Date d1, Date d2) {
        boolean executed = false;
        try {
            statement = con.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(d1.getTime()));
            statement.setDate(2, new java.sql.Date(d2.getTime()));
            statement.execute();
            executed = true;
        } catch (Exception ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executed;
    }

    /**
     * Function to execute retrival query
     *
     * @param sql
     * @return
     */
    public ResultSet executeStatement(String sql) {
        ResultSet rSet = null;
        try {
            statement = con.prepareStatement(sql);
            rSet = statement.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rSet;
    }

    /**
     * Function to close connections
     *
     * @return
     */
    public boolean closeConnection() {
        boolean isClosed = false;

        try {
            if (con != null) {
                if (!con.isClosed()) {
                    con.close();
                }
            }
            if (statement != null) {
                if (!statement.isClosed()) {
                    statement.close();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isClosed;
    }

}
