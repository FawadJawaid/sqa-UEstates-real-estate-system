/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessLayer.DAL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsalan
 */
public class CustomerManager {

    private DAL dal;

    public CustomerManager(DAL dal) {
        this.dal = dal;
    }

    /**
     * Function to add customer
     *
     * @param customer
     * @return
     */
    public boolean addCustomer(Customer customer) {
        boolean updated = false;
        String sql;
        try {
            sql = "SELECT * from `customer` WHERE `cnic`= '" + customer.getCnic() + "';";
            ResultSet set = dal.executeStatement(sql);
            if (set.next()) {

            } else {
                sql = "INSERT INTO `customer`(`customerName`, `phoneNo`, `cnic`, `address`) VALUES ('" + customer.getName() + "','" + customer.getNumber() + "','" + customer.getCnic() + "','" + customer.getAddress() + "');";
                updated = dal.createStatement(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }

    /**
     * Function to update customer
     *
     * @param customer
     * @return
     */
    public boolean updateCustomer(Customer customer) {
        boolean updated = false;
        String sql;
        try {
            sql = "SELECT * from `customer` WHERE `cnic`= '" + customer.getCnic() + "' and `customerId` != " + customer.getId() + ";";

            ResultSet set = dal.executeStatement(sql);
            if (set.next()) {

            } else {
                sql = "UPDATE `customer` SET `customerName`='" + customer.getName() + "',`phoneNo`='" + customer.getNumber() + "',`cnic`='" + customer.getCnic() + "',`address`='" + customer.getAddress() + "' WHERE `customerId`=" + customer.getId() + ";";
                updated = dal.createStatement(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }

    /**
     * Function to get all customers
     *
     * @return
     */
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> list = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM `customer`;";
            ResultSet set = dal.executeStatement(sql);
            Customer customer;
            while (set.next()) {
                customer = new Customer();
                customer.setId(set.getInt(1));
                customer.setName(set.getString(2));
                customer.setNumber(set.getString(3));
                customer.setCnic(set.getString(4));
                customer.setAddress(set.getString(5));
                list.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
