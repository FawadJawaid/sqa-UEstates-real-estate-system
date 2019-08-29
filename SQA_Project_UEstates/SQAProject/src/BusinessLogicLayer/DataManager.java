/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessLayer.DAL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author arsalan
 */
public class DataManager {

    private static DataManager dataManager;
    private User user;
    private DAL dal;
    private CustomerManager customerManager;
    private AgentManager agentManager;
    private PropertyManager propertyManager;

    private DataManager() {
        user = new User();
        dal = new DAL();
        customerManager = new CustomerManager(dal);
        agentManager = new AgentManager(dal);
        propertyManager = new PropertyManager(dal);
    }

    /**
     * Function to get instance of class
     *
     * @return
     */
    public static DataManager getInstance() {
        if (dataManager == null) {
            synchronized (DataManager.class) {
                if (dataManager == null) {
                    dataManager = new DataManager();
                }
            }
        }
        return dataManager;
    }

    /**
     * Function to connect with database
     *
     * @param dbName
     * @param id
     * @param pass
     * @return
     */
    public boolean connectToDatabase(String dbName, String id, String pass) {
        return dal.setUpConnection(dbName, id, pass);
    }

    /**
     * Function to close database connection
     */
    public void closeDatabase() {
        dal.closeConnection();
    }

    /**
     * function to get current user
     *
     * @return
     */
    public User getCurrentUser() {
        return user;
    }

    /**
     * Function to get customer manager instance
     *
     * @return
     */
    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    /**
     * Function to get agent manager instance
     *
     * @return
     */
    public AgentManager getAgentManager() {
        return agentManager;
    }

    /**
     * Function to get property manager instance
     *
     * @return
     */
    public PropertyManager getPropertyManager() {
        return propertyManager;
    }

    /**
     * function to check for validity of user
     *
     * @param id
     * @param pass
     * @return
     */
    public boolean isValidUser(String id, String pass) {
        boolean isValid = false;
        try {
            String sql = "SELECT * FROM `agent` WHERE `loginId` = '" + id + "' and `password` = '" + pass + "'";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {
                user.setId(rSet.getInt(1));
                user.setName(rSet.getString(2));
                user.setLoginId(rSet.getString(3));
                user.setPass(rSet.getString(4));
                user.setCategory(rSet.getString(5));
                isValid = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValid;
    }

    /**
     * Function to export data to excel file
     *
     * @param table
     * @param dataOf
     */
    public void exportDataToExcel(JTable table, String dataOf) {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm.ss");
        ExcelExporter exp = new ExcelExporter();
        exp.fillData(table, new File(dataOf + "DataAt(" + sdf.format(cal.getTime()) + ").xls"), dataOf + " Data");
    }

    /**
     * Function to check validity of password
     *
     * @param pass
     * @return
     */
    public boolean isValidPassword(String pass) {
        return user.getPass().equals(pass);
    }

    /**
     * Function to copy image from one path to other
     *
     * @param pathFrom
     * @param pathTo
     * @return
     */
    public boolean copyImage(String pathFrom, String pathTo) {
        boolean copied = false;
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(pathFrom).getChannel();
            outputChannel = new FileOutputStream(pathTo).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception ex) {
            copied = false;
        } finally {
            try {
                copied = true;
                inputChannel.close();
                outputChannel.close();
            } catch (IOException ex) {
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return copied;
    }

    /**
     * Function to create a folder
     *
     * @param folderName
     */
    public void createFolder(String folderName) {

        File theDir = new File(folderName);
        if (!theDir.exists()) {
            boolean result = false;
            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
        }
    }

}
