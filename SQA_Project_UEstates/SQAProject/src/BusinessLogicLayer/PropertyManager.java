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
public class PropertyManager {

    private DAL dal;

    public PropertyManager(DAL dal) {
        this.dal = dal;
    }

//--------------------------------------------
//---------- Add Functions Starts ------------
//--------------------------------------------
    /**
     * Function to add area
     *
     * @param area
     * @return
     */
    public boolean addArea(Area area) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `area` WHERE `areaName` = '" + area.getAreaName() + "';";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `area`(`areaName`) VALUES ('" + area.getAreaName() + "')";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add Block
     *
     * @param block
     * @return
     */
    public boolean addBlock(Block block) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `block` WHERE `blockName` = '" + block.getBlockName() + "' and `areaId` = " + block.getAreaId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `block`(`blockName`, `noOfHoursLoadShed`, `pricePerFt`, `areaId`) VALUES ('" + block.getBlockName() + "'," + block.getNoOfHourOfLoadShed() + "," + block.getPricePerFt() + "," + block.getAreaId() + ");";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add type
     *
     * @param type
     * @return
     */
    public boolean addType(PropertyType type) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `propertytype` WHERE `typeName` = '" + type.getTypeName() + "';";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `propertytype`(`typeName`) VALUES ('" + type.getTypeName() + "')";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add service
     *
     * @param service
     * @return
     */
    public boolean addService(PropertyService service) {
        boolean isAdded = false;
        try {
            String sql = "SELECT * FROM `propertyservices` WHERE `serviceName` = '" + service.getServiceName() + "' and `serviceId` != " + service.getServiceId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `propertyservices`(`serviceName`) VALUES ('" + service.getServiceName() + "')";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add characteristic
     *
     * @param characteristic
     * @return
     */
    public boolean addCharacteristic(PropertyCharacteristic characteristic) {
        boolean isAdded = false;
        try {
            String sql = "Select * from `propertycharacteristics` where `characteristicsName` = '" + characteristic.getCharacteristicName() + "';";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "INSERT INTO `propertycharacteristics`(`characteristicsName`) VALUES ('" + characteristic.getCharacteristicName() + "');";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add property
     *
     * @param property
     * @return
     */
    public boolean addProperty(Property property) {
        boolean isAdded = false;
        ResultSet rSet;
        String sql;

        try {
            sql = "SELECT * FROM `property` WHERE `blockId` = " + property.getBlock().getBlockId() + " and `address` = '" + property.getAddress() + "';";
            rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                int customerId = property.getCustomer().getId();
                int blockId = property.getBlock().getBlockId();
                int filterId = property.getFilter().getFilterId();
                int typeId = property.getType().getTypeId();
                sql = "INSERT INTO `property`(`customerid`, `size`, `demand`, `variation`, `sellingPrice`, `agreement`, `isAvalible`, `isResidential`, `noOfRooms`, `dateOfOwnerShip`, `dateOfArrival`, `address`, `typeId`, `blockId`, `filterId`) VALUES ("
                        + customerId + "," + property.getSize() + "," + property.getDemand() + "," + property.getVariation() + ",0,'" + property.getAgreement() + "'," + property.isAvalible() + "," + property.isResidential() + " ," + property.getNoOfRooms() + ",?,?,'" + property.getAddress() + "'," + typeId + "," + blockId + "," + filterId + ");";

                isAdded = dal.createStatement(sql, property.getDateOfOwnerShip(), property.getDateOfEntry());
                if (isAdded) {
                    int propertyId = getPropertyLatestId();
                    if (propertyId >= 0) {
                        property.setPropertyId(propertyId);
                        addServicesOfProperty(property);
                        addCharacteristicsOfProperty(property);
                        addImagesOfProperty(property);
                    } else {
                        isAdded = false;
                    }
                }
            }
        } catch (SQLException ex) {
            isAdded = false;
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to get latest image id
     *
     * @return
     */
    private int getImageLatestId() {
        int id = 0;
        try {
            ResultSet rSet;
            String sql = "SELECT max(`imageId`) FROM `propertyimage`";
            rSet = dal.executeStatement(sql);
            if (rSet.next()) {
                id = rSet.getInt(1);
                id++;
            } else {
                id = 1;
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * Function to get latest property id
     *
     * @return
     */
    private int getPropertyLatestId() {
        int id = -1;
        try {
            ResultSet rSet;
            String sql = "SELECT max(`propertyId`) FROM `property`";
            rSet = dal.executeStatement(sql);
            if (rSet.next()) {
                id = rSet.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * Function to add services for a property
     *
     * @param property
     * @return
     */
    private boolean addServicesOfProperty(Property property) {
        boolean isAdded = true;
        try {
            ArrayList<PropertyService> services = property.getServices();
            PropertyService service;
            String sql;
            for (int i = 0; i < services.size() && isAdded; i++) {
                service = services.get(i);
                sql = "INSERT INTO `propertyhasservices`(`serviceId`, `propertyId`) VALUES (" + service.getServiceId() + "," + property.getPropertyId() + ");";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            isAdded = false;
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isAdded;
    }

    /**
     * Function to add characteristic for property
     *
     * @param property
     * @return
     */
    private boolean addCharacteristicsOfProperty(Property property) {
        boolean isAdded = true;
        try {
            ArrayList<PropertyCharacteristic> characteristics = property.getCharacteristics();
            PropertyCharacteristic characteristic;
            String sql;
            for (int i = 0; i < characteristics.size() && isAdded; i++) {
                characteristic = characteristics.get(i);
                sql = "INSERT INTO `propertyhascharacteristics`(`characteristicsId`, `propertyId`, `quantity`) VALUES (" + characteristic.getCharacteristicId() + "," + property.getPropertyId() + "," + characteristic.getQuantity() + ");";
                isAdded = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            isAdded = false;
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdded;
    }

    /**
     * Function to add images for property
     *
     * @param property
     * @return
     */
    private boolean addImagesOfProperty(Property property) {
        boolean isAdded = false;
        ArrayList<String> links = property.getImages();
        DataManager dataManager = DataManager.getInstance();
        String customerName = property.getCustomer().getName();
        int propertyId = property.getPropertyId();
        String sql;
        dataManager.createFolder("Images\\" + customerName);
        int id;
        String filePath;
        for (int i = 0; i < links.size(); i++) {
            try {
                id = getImageLatestId();
                filePath = "Images\\" + customerName + "\\Image_" + id + ".jpg";
                dataManager.copyImage(links.get(i), filePath);
                sql = "INSERT INTO `propertyimage`(`imageLink`, `propertyId`) VALUES ('" + filePath + "'," + propertyId + ");";
                isAdded = dal.createStatement(sql);
            } catch (Exception ex) {
                Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isAdded;
    }

//--------------------------------------------
//-------- Update Functions Starts -----------
//--------------------------------------------
    /**
     * Function to Update Area
     *
     * @param area
     * @return
     */
    public boolean updateArea(Area area) {
        boolean isUpdated = false;

        try {
            String sql = "SELECT * FROM `area` WHERE `areaName` = '" + area.getAreaName() + "' and `areaId` != " + area.getAreaId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `area` SET `areaName`= '" + area.getAreaName() + "' WHERE `areaId` = " + area.getAreaId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Block
     *
     * @param block
     * @return
     */
    public boolean updateBlock(Block block) {
        boolean isUpdated = false;
        try {
            String sql = "SELECT * FROM `block` WHERE `blockName` = '" + block.getBlockName() + "' and `areaId` = " + block.getAreaId() + " and `blockId` != " + block.getBlockId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `block` SET `blockName`='" + block.getBlockName() + "',`noOfHoursLoadShed` = " + block.getNoOfHourOfLoadShed() + ",`pricePerFt` = " + block.getPricePerFt() + " WHERE `blockId` = " + block.getBlockId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Type
     *
     * @param type
     * @return
     */
    public boolean updateType(PropertyType type) {
        boolean isUpdated = false;
        try {
            String sql = "SELECT * FROM `propertytype` WHERE `typeName` = '" + type.getTypeName() + "' and `typeId` != " + type.getTypeId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `propertytype` SET `typeName` = '" + type.getTypeName() + "' WHERE `typeId` = " + type.getTypeId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Service
     *
     * @param service
     * @return
     */
    public boolean updateService(PropertyService service) {
        boolean isUpdated = false;
        try {
            String sql = "SELECT * FROM `propertyservices` WHERE `serviceName` = '" + service.getServiceName() + "' and `serviceId` != " + service.getServiceId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `propertyservices` SET `serviceName` = '" + service.getServiceName() + "' WHERE `serviceId` = " + service.getServiceId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

    /**
     * Function to Update Characteristic
     *
     * @param characteristic
     * @return
     */
    public boolean updateCharacteristic(PropertyCharacteristic characteristic) {
        boolean isUpdated = false;
        try {
            String sql = "Select * from `propertycharacteristics` where `characteristicsName` = '" + characteristic.getCharacteristicName() + "' and `characteristicsId` != " + characteristic.getCharacteristicId() + ";";
            ResultSet rSet = dal.executeStatement(sql);
            if (rSet.next()) {

            } else {
                sql = "UPDATE `propertycharacteristics` SET `characteristicsName` = '" + characteristic.getCharacteristicName() + "' WHERE `characteristicsId` = " + characteristic.getCharacteristicId() + ";";
                isUpdated = dal.createStatement(sql);
            }
        } catch (Exception ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdated;
    }

//--------------------------------------------
//----- List Retrival Functions Starts -------
//--------------------------------------------
    /**
     * Function to retrieve all Areas
     *
     * @return
     */
    public ArrayList<Area> getAreas() {
        ArrayList<Area> list = new ArrayList<Area>();
        try {
            String sql = "SELECT * FROM `area`;";
            ResultSet set = dal.executeStatement(sql);
            Area area;
            while (set.next()) {
                area = new Area();
                area.setAreaId(set.getInt(1));
                area.setAreaName(set.getString(2));
                list.add(area);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all blocks of area
     *
     * @param areaId
     * @return
     */
    public ArrayList<Block> getBlocksOfArea(int areaId) {
        ArrayList<Block> list = new ArrayList<Block>();
        try {
            String sql = "SELECT * FROM `block` where `areaId` = " + areaId + ";";
            ResultSet set = dal.executeStatement(sql);
            Block block;
            while (set.next()) {
                block = new Block();
                block.setBlockId(set.getInt(1));
                block.setBlockName(set.getString(2));
                block.setNoOfHourOfLoadShed(set.getInt(3));
                block.setPricePerFt(set.getInt(4));
                block.setAreaId(set.getInt(5));
                list.add(block);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all property types
     *
     * @return
     */
    public ArrayList<PropertyType> getPropertyTypes() {
        ArrayList<PropertyType> list = new ArrayList<PropertyType>();
        try {
            String sql = "SELECT * FROM `propertytype`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyType propertyType;
            while (set.next()) {
                propertyType = new PropertyType();
                propertyType.setTypeId(set.getInt(1));
                propertyType.setTypeName(set.getString(2));
                list.add(propertyType);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all characteristics
     *
     * @return
     */
    public ArrayList<PropertyCharacteristic> getPropertyCharacteristics() {
        ArrayList<PropertyCharacteristic> list = new ArrayList<PropertyCharacteristic>();
        try {
            String sql = "SELECT * FROM `propertycharacteristics`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyCharacteristic characteristic;
            while (set.next()) {
                characteristic = new PropertyCharacteristic();
                characteristic.setCharacteristicId(set.getInt(1));
                characteristic.setCharacteristicName(set.getString(2));
                list.add(characteristic);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all services
     *
     * @return
     */
    public ArrayList<PropertyService> getPropertyServices() {
        ArrayList<PropertyService> list = new ArrayList<PropertyService>();
        try {
            String sql = "SELECT * FROM `propertyservices`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyService service;
            while (set.next()) {
                service = new PropertyService();
                service.setServiceId(set.getInt(1));
                service.setServiceName(set.getString(2));
                list.add(service);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Function to retrieve all filters
     *
     * @return
     */
    public ArrayList<PropertyFilter> getPropertyFilters() {
        ArrayList<PropertyFilter> list = new ArrayList<PropertyFilter>();
        try {
            String sql = "SELECT * FROM `propertyfilter`;";
            ResultSet set = dal.executeStatement(sql);
            PropertyFilter filter;
            while (set.next()) {
                filter = new PropertyFilter();
                filter.setFilterId(set.getInt(1));
                filter.setFilterName(set.getString(2));
                list.add(filter);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
