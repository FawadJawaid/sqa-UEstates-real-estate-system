/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author arsalan
 */
public class Property {

    private int propertyId;
    private Customer customer;
    private PropertyType type;
    private PropertyFilter filter;
    private Block block;
    private Date dateOfOwnerShip;
    private Date dateOfEntry;
    private int size;
    private int demand;
    private int variation;
    private int noOfRooms;
    private int sellingPrice;
    private String address;
    private String agreement;
    private boolean isResidential;
    private boolean isAvalible;
    private ArrayList<PropertyCharacteristic> characteristics;
    private ArrayList<PropertyService> services;
    private ArrayList<String> images;

    public Property(Customer customer,
            PropertyType type,
            PropertyFilter filter,
            Block block,
            Date dateOfOwnerShip,
            Date dateOfEntry,
            int size,
            int demand,
            int variation,
            String address,
            String agreement,
            boolean isResidential,
            ArrayList<PropertyCharacteristic> characteristics,
            ArrayList<PropertyService> services,
            ArrayList<String> images) {
        this.customer = customer;
        this.type = type;
        this.filter = filter;
        this.block = block;
        this.dateOfOwnerShip = dateOfOwnerShip;
        this.dateOfEntry = dateOfEntry;
        this.size = size;
        this.demand = demand;
        this.variation = variation;
        this.address = address;
        this.agreement = agreement;
        this.isResidential = isResidential;
        this.characteristics = characteristics;
        this.services = services;
        this.images = images;
        this.isAvalible = true;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public PropertyFilter getFilter() {
        return filter;
    }

    public void setFilter(PropertyFilter filter) {
        this.filter = filter;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Date getDateOfOwnerShip() {
        return dateOfOwnerShip;
    }

    public void setDateOfOwnerShip(Date dateOfOwnerShip) {
        this.dateOfOwnerShip = dateOfOwnerShip;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getVariation() {
        return variation;
    }

    public void setVariation(int variation) {
        this.variation = variation;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public boolean isResidential() {
        return isResidential;
    }

    public void setIsResidential(boolean isResidential) {
        this.isResidential = isResidential;
    }

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setIsAvalible(boolean isAvalible) {
        this.isAvalible = isAvalible;
    }

    public ArrayList<PropertyCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(ArrayList<PropertyCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public ArrayList<PropertyService> getServices() {
        return services;
    }

    public void setServices(ArrayList<PropertyService> services) {
        this.services = services;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

}
