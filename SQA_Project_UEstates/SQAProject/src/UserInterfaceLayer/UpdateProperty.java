/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import BusinessLogicLayer.Area;
import BusinessLogicLayer.Block;
import BusinessLogicLayer.Customer;
import BusinessLogicLayer.CustomerManager;
import BusinessLogicLayer.DataManager;
import BusinessLogicLayer.PropertyCharacteristic;
import BusinessLogicLayer.PropertyFilter;
import BusinessLogicLayer.PropertyManager;
import BusinessLogicLayer.PropertyService;
import BusinessLogicLayer.PropertyType;
import BusinessLogicLayer.Validations;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arsalan
 */
public class UpdateProperty extends javax.swing.JPanel {

    private ArrayList<Customer> customerList;
    private ArrayList<PropertyType> propertyTypeList;
    private ArrayList<Block> blocksList;
    private ArrayList<Area> areaList;
    private ArrayList<PropertyFilter> propertyForList;
    private ArrayList<PropertyCharacteristic> characteristicList;
    private ArrayList<PropertyCharacteristic> selectedCharacteristic;
    private ArrayList<PropertyService> serviceList;
    private ArrayList<PropertyService> selectedServices;
    private ArrayList<String> selectedImagesLinks;
    private PropertyManager propertyManager;
    private CustomerManager customerManager;
    private DefaultTableModel model;
    private DialogBox dialog;
    private Validations validation;

    /**
     * Creates new form UpdateProperty
     */
    public UpdateProperty() {
        initComponents();
        /*      validation = new Validations();
         propertyManager = DataManager.getInstance().getPropertyManager();
         customerManager = DataManager.getInstance().getCustomerManager();
         selectedServices = new ArrayList<>();
         selectedCharacteristic = new ArrayList<>();
         selectedImagesLinks = new ArrayList<>();
         dialog = new DialogBox();
         lstServices.setCellRenderer(new UpdateProperty.CheckListRenderer());
         fillAllDropDown();*/
    }

    public void fillAllDropDown() {
        /*  fillAreaDropDown();
         fillCustomerDropDown();
         fillPropertyForDropDown();
         fillPropertyTypeDropDown();
         fillPropertyCharacteristicDropDown();
         createCheckBoxList();*/
    }

    private void disableCustomers() {
        cmbCustomers.setEnabled(false);
        disableArea();
    }

    private void disableArea() {
        cmbAreas.setEnabled(false);
        disableBlock();
    }

    private void disableBlock() {
        cmbBlocks.setEnabled(false);
        disablePropertyType();
    }

    private void disablePropertyType() {
        cmbPropertyType.setEnabled(false);
        disablePropertyFor();
    }

    private void disablePropertyFor() {
        cmbPropertyFilter.setEnabled(false);
        disableAllElements();
    }

    private void disableAllElements() {
        spinDate.setEnabled(false);
        spinDemand.setEnabled(false);
        spinNoOfRooms.setEnabled(false);
        spinQuantity.setEnabled(false);
        spinSize.setEnabled(false);
        spinVariation.setEnabled(false);
        chkIsResidential.setEnabled(false);
        txtAddress.setEnabled(false);
        txtAgreement.setEnabled(false);
        lstServices.setEnabled(false);
        cmbCharacteristics.setEnabled(false);
        btnAddCharacteristic.setEnabled(false);
        btnRemoveCharacteristic.setEnabled(false);
        tblCharacteristics.setEnabled(false);
        btnAddProperty.setEnabled(false);
        btnAddImage.setEnabled(false);
        tblImages.setEnabled(false);
        btnRemoveImage.setEnabled(false);
    }

    private void enableCustomers() {
        cmbCustomers.setEnabled(true);
        enableArea();
    }

    private void enableArea() {
        cmbAreas.setEnabled(true);
        enableBlock();
    }

    private void enableBlock() {
        cmbBlocks.setEnabled(true);
        enablePropertyType();
    }

    private void enablePropertyType() {
        cmbPropertyType.setEnabled(true);
        enablePropertyFor();
    }

    private void enablePropertyFor() {
        cmbPropertyFilter.setEnabled(true);
        enableAllElements();
    }

    private void enableAllElements() {
        spinDate.setEnabled(true);
        spinDemand.setEnabled(true);
        spinNoOfRooms.setEnabled(true);
        spinQuantity.setEnabled(true);
        spinSize.setEnabled(true);
        spinVariation.setEnabled(true);
        chkIsResidential.setEnabled(true);
        txtAddress.setEnabled(true);
        txtAgreement.setEnabled(true);
        lstServices.setEnabled(true);
        cmbCharacteristics.setEnabled(true);
        btnAddCharacteristic.setEnabled(true);
        btnRemoveCharacteristic.setEnabled(true);
        tblCharacteristics.setEnabled(true);
        btnAddProperty.setEnabled(true);
        btnAddImage.setEnabled(true);
        tblImages.setEnabled(true);
        btnRemoveImage.setEnabled(true);
    }

    private void fillPropertyCharacteristicDropDown() {
        characteristicList = propertyManager.getPropertyCharacteristics();
        cmbCharacteristics.removeAllItems();
        if (characteristicList.size() > 0) {
            PropertyCharacteristic characteristic;
            for (int i = 0; i < characteristicList.size(); i++) {
                characteristic = characteristicList.get(i);
                cmbCharacteristics.addItem(characteristic.getCharacteristicName());
            }
        } else {

        }
    }

    private void fillPropertyForDropDown() {
        propertyForList = propertyManager.getPropertyFilters();
        cmbPropertyFilter.removeAllItems();
        if (propertyForList.size() > 0) {
            enablePropertyFor();
            PropertyFilter filter;
            for (int i = 0; i < propertyForList.size(); i++) {
                filter = propertyForList.get(i);
                cmbPropertyFilter.addItem(filter.getFilterName());
            }
        } else {
            disablePropertyFor();
        }
    }

    private void fillPropertyTypeDropDown() {
        propertyTypeList = propertyManager.getPropertyTypes();
        cmbPropertyType.removeAllItems();
        if (propertyTypeList.size() > 0) {
            enablePropertyType();
            PropertyType propertyType;
            for (int i = 0; i < propertyTypeList.size(); i++) {
                propertyType = propertyTypeList.get(i);
                cmbPropertyType.addItem(propertyType.getTypeName());
            }
        } else {
            disablePropertyType();
        }
    }

    private void fillCustomerDropDown() {
        customerList = customerManager.getCustomers();
        cmbCustomers.removeAllItems();
        if (customerList.size() > 0) {
            enableCustomers();
            Customer customer;
            for (int i = 0; i < customerList.size(); i++) {
                customer = customerList.get(i);
                cmbCustomers.addItem(customer.getName());
            }
        } else {
            disableCustomers();
        }
    }

    private void fillAreaDropDown() {
        areaList = propertyManager.getAreas();
        cmbAreas.removeAllItems();
        if (areaList.size() > 0) {
            Area area;
            for (int i = 0; i < areaList.size(); i++) {
                area = areaList.get(i);
                cmbAreas.addItem(area.getAreaName());
            }
        } else {

        }
    }

    private void fillBlockDropDown() {
        int index = cmbAreas.getSelectedIndex();
        if (index >= 0) {
            blocksList = propertyManager.getBlocksOfArea(areaList.get(index).getAreaId());
            cmbBlocks.removeAllItems();
            if (blocksList.size() > 0) {
                Block block;
                enableBlock();
                for (int i = 0; i < blocksList.size(); i++) {
                    block = blocksList.get(i);
                    cmbBlocks.addItem(block.getBlockName());
                }
            } else {
                disableBlock();
            }
        } else {
            disableArea();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbProperties = new javax.swing.JComboBox();
        cmbPropertyType = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmbCharacteristics = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cmbBlocks = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        cmbPropertyFilter = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spinSize = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        spinDemand = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        spinVariation = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        spinQuantity = new javax.swing.JSpinner();
        chkIsResidential = new javax.swing.JCheckBox();
        spinDate = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstServices = new javax.swing.JList();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAgreement = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cmbAreas = new javax.swing.JComboBox();
        spinNoOfRooms = new javax.swing.JSpinner();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCharacteristics = new javax.swing.JTable();
        btnRemoveCharacteristic = new javax.swing.JButton();
        btnAddCharacteristic = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnAddProperty = new javax.swing.JButton();
        lblAddPropertyError = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblImages = new javax.swing.JTable();
        btnRemoveImage = new javax.swing.JButton();
        btnAddImage = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        fileChoser = new javax.swing.JFileChooser();
        cmbCustomers = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();

        jPanel11.setLayout(null);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel60.setText("UPDATE PROPERTY");
        jPanel11.add(jLabel60);
        jLabel60.setBounds(420, 0, 340, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Property");
        jPanel11.add(jLabel11);
        jLabel11.setBounds(680, 50, 70, 30);

        cmbProperties.setToolTipText("Select Owner of Property");
        cmbProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropertiesActionPerformed(evt);
            }
        });
        jPanel11.add(cmbProperties);
        cmbProperties.setBounds(760, 50, 190, 30);

        cmbPropertyType.setToolTipText("Select Property Type");
        jPanel11.add(cmbPropertyType);
        cmbPropertyType.setBounds(140, 110, 190, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Property Type");
        jPanel11.add(jLabel12);
        jLabel12.setBounds(50, 110, 90, 30);

        cmbCharacteristics.setToolTipText("Select Characteristic of Property");
        jPanel11.add(cmbCharacteristics);
        cmbCharacteristics.setBounds(410, 230, 130, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Area");
        jPanel11.add(jLabel13);
        jLabel13.setBounds(290, 50, 50, 30);

        cmbBlocks.setToolTipText("Select Block of Area for Property");
        jPanel11.add(cmbBlocks);
        cmbBlocks.setBounds(550, 50, 110, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Date of Ownership");
        jPanel11.add(jLabel14);
        jLabel14.setBounds(700, 110, 120, 30);

        cmbPropertyFilter.setToolTipText("Select Purpose of Property");
        jPanel11.add(cmbPropertyFilter);
        cmbPropertyFilter.setBounds(440, 110, 220, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Property For");
        jPanel11.add(jLabel15);
        jLabel15.setBounds(350, 110, 80, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Address");
        jPanel11.add(jLabel16);
        jLabel16.setBounds(20, 200, 70, 30);

        spinSize.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(10), null, Integer.valueOf(1)));
        spinSize.setToolTipText("Select Size of Property ");
        jPanel11.add(spinSize);
        spinSize.setBounds(120, 160, 70, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Demand");
        jPanel11.add(jLabel17);
        jLabel17.setBounds(230, 160, 70, 30);

        spinDemand.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5000), Integer.valueOf(5000), null, Integer.valueOf(1000)));
        spinDemand.setToolTipText("Select Demand for Property");
        jPanel11.add(spinDemand);
        spinDemand.setBounds(300, 160, 110, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Property Images");
        jPanel11.add(jLabel18);
        jLabel18.setBounds(690, 230, 110, 30);

        spinVariation.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1000), Integer.valueOf(1000), null, Integer.valueOf(500)));
        spinVariation.setToolTipText("Select Variation in Demand");
        jPanel11.add(spinVariation);
        spinVariation.setBounds(520, 160, 90, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Number of Rooms");
        jPanel11.add(jLabel20);
        jLabel20.setBounds(640, 160, 110, 30);

        spinQuantity.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        spinQuantity.setToolTipText("Select Quantity of Characteristic");
        jPanel11.add(spinQuantity);
        spinQuantity.setBounds(550, 230, 50, 30);

        chkIsResidential.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chkIsResidential.setText("Residential");
        chkIsResidential.setToolTipText("Is Property Residential?");
        jPanel11.add(chkIsResidential);
        chkIsResidential.setBounds(850, 160, 100, 30);

        spinDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.YEAR));
        spinDate.setToolTipText("Select Date of ownership");
        jPanel11.add(spinDate);
        spinDate.setBounds(820, 110, 130, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Block");
        jPanel11.add(jLabel21);
        jLabel21.setBounds(490, 50, 60, 30);

        lstServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstServicesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstServices);

        jPanel11.add(jScrollPane2);
        jScrollPane2.setBounds(270, 230, 130, 220);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Size in Sq Ft");
        jPanel11.add(jLabel22);
        jLabel22.setBounds(30, 160, 90, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Characteristics");
        jPanel11.add(jLabel23);
        jLabel23.setBounds(410, 200, 130, 30);

        txtAgreement.setColumns(20);
        txtAgreement.setRows(5);
        jScrollPane3.setViewportView(txtAgreement);

        jPanel11.add(jScrollPane3);
        jScrollPane3.setBounds(20, 350, 240, 100);

        txtAddress.setColumns(20);
        txtAddress.setRows(4);
        txtAddress.setToolTipText("Enter Property Address");
        jScrollPane4.setViewportView(txtAddress);

        jPanel11.add(jScrollPane4);
        jScrollPane4.setBounds(20, 230, 240, 90);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Agreement");
        jPanel11.add(jLabel24);
        jLabel24.setBounds(20, 320, 100, 30);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Services");
        jPanel11.add(jLabel25);
        jLabel25.setBounds(270, 200, 90, 30);

        cmbAreas.setToolTipText("Select Area of Property");
        cmbAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreasActionPerformed(evt);
            }
        });
        jPanel11.add(cmbAreas);
        cmbAreas.setBounds(340, 50, 130, 30);

        spinNoOfRooms.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinNoOfRooms.setToolTipText("Select Number of rooms");
        jPanel11.add(spinNoOfRooms);
        spinNoOfRooms.setBounds(750, 160, 70, 30);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Variation");
        jPanel11.add(jLabel26);
        jLabel26.setBounds(450, 160, 70, 30);

        tblCharacteristics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Characteristic", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblCharacteristics);

        jPanel11.add(jScrollPane5);
        jScrollPane5.setBounds(410, 270, 270, 150);

        btnRemoveCharacteristic.setText("Remove Characteristic");
        btnRemoveCharacteristic.setToolTipText("Remove Characteristic");
        btnRemoveCharacteristic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveCharacteristic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCharacteristicActionPerformed(evt);
            }
        });
        jPanel11.add(btnRemoveCharacteristic);
        btnRemoveCharacteristic.setBounds(510, 420, 170, 30);

        btnAddCharacteristic.setText("Add");
        btnAddCharacteristic.setToolTipText("Add Characteristic");
        btnAddCharacteristic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCharacteristic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCharacteristicActionPerformed(evt);
            }
        });
        jPanel11.add(btnAddCharacteristic);
        btnAddCharacteristic.setBounds(610, 230, 60, 30);

        btnReset.setText("Reset");
        btnReset.setToolTipText("Reset Values");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.add(btnReset);
        btnReset.setBounds(360, 460, 110, 30);

        btnAddProperty.setText("Add Property");
        btnAddProperty.setToolTipText("Add Property");
        btnAddProperty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPropertyActionPerformed(evt);
            }
        });
        jPanel11.add(btnAddProperty);
        btnAddProperty.setBounds(500, 460, 120, 30);

        lblAddPropertyError.setText("Property Already Exists");
        jPanel11.add(lblAddPropertyError);
        lblAddPropertyError.setBounds(640, 460, 310, 30);

        tblImages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Link"
            }
        ));
        tblImages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImagesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblImages);

        jPanel11.add(jScrollPane6);
        jScrollPane6.setBounds(690, 270, 270, 150);

        btnRemoveImage.setText("Remove Image");
        btnRemoveImage.setToolTipText("Remove Image");
        btnRemoveImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveImageActionPerformed(evt);
            }
        });
        jPanel11.add(btnRemoveImage);
        btnRemoveImage.setBounds(790, 420, 170, 30);

        btnAddImage.setText("Add Image");
        btnAddImage.setToolTipText("Add Image");
        btnAddImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });
        jPanel11.add(btnAddImage);
        btnAddImage.setBounds(850, 230, 110, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Quantity");
        jPanel11.add(jLabel27);
        jLabel27.setBounds(540, 200, 70, 30);
        jPanel11.add(jSeparator1);
        jSeparator1.setBounds(0, 90, 1040, 20);
        jPanel11.add(fileChoser);
        fileChoser.setBounds(10, 10, 10, 10);

        cmbCustomers.setToolTipText("Select Owner of Property");
        cmbCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomersActionPerformed(evt);
            }
        });
        jPanel11.add(cmbCustomers);
        cmbCustomers.setBounds(80, 50, 190, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Owner");
        jPanel11.add(jLabel19);
        jLabel19.setBounds(10, 50, 70, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstServicesMouseClicked
        // TODO add your handling code here:
        int index = lstServices.locationToIndex(evt.getPoint());
        if (index >= 0) {
            CheckListItem item = (CheckListItem) lstServices.getModel().getElementAt(index);

            // Toggle selected state
            item.setSelected(!item.isSelected());

            // Repaint cell
            lstServices.repaint(lstServices.getCellBounds(index, index));
            PropertyService service = serviceList.get(lstServices.getSelectedIndex());
            if (!selectedServices.contains(service)) {
                selectedServices.add(service);
            } else {
                selectedServices.remove(service);
            }
        }
    }//GEN-LAST:event_lstServicesMouseClicked

    private void cmbAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreasActionPerformed
        // TODO add your handling code here:
        fillBlockDropDown();
    }//GEN-LAST:event_cmbAreasActionPerformed

    private void btnRemoveCharacteristicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCharacteristicActionPerformed
        // TODO add your handling code here:
        int index = tblCharacteristics.getSelectedRow();
        if (index >= 0) {
            selectedCharacteristic.remove(index);
            model = (DefaultTableModel) tblCharacteristics.getModel();
            model.removeRow(index);
        } else {
            dialog.show("Please Select a row");
        }
    }//GEN-LAST:event_btnRemoveCharacteristicActionPerformed

    private void btnAddCharacteristicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCharacteristicActionPerformed
        // TODO add your handling code here:
        int index = cmbCharacteristics.getSelectedIndex();
        model = (DefaultTableModel) tblCharacteristics.getModel();
        PropertyCharacteristic characteristic = characteristicList.get(index);
        if (!selectedCharacteristic.contains(characteristic)) {
            characteristic.setQuantity((int) spinQuantity.getValue());
            model.insertRow(tblCharacteristics.getRowCount(), new Object[]{characteristic.getCharacteristicName(), characteristic.getQuantity()});
            selectedCharacteristic.add(characteristic);
        } else {
            dialog.show("Characteristic Already Added");
        }
    }//GEN-LAST:event_btnAddCharacteristicActionPerformed

    private void btnAddPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPropertyActionPerformed
        // TODO add your handling code here:
 /*      
         Customer customer = customerList.get(cmbCustomers.getSelectedIndex());
         PropertyType type = propertyTypeList.get(cmbPropertyType.getSelectedIndex());
         Block block = blocksList.get(cmbBlocks.getSelectedIndex());
         PropertyFilter filter = propertyForList.get(cmbPropertyFilter.getSelectedIndex());
         int size = (int) spinSize.getValue();
         int demand = (int) spinDemand.getValue();
         int variation = (int) spinVariation.getValue();
         String address = txtAddress.getText();
         String agreement = txtAgreement.getText();
         boolean isResidential = chkIsResidential.isSelected();
         Date dateOfOwnership = (Date) spinDate.getValue();
         Date currentDate = new Date();
         SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
         //        String strDate = sdfDate.format(currentDate);
         if (!validation.isEmpty(address)) {
         if (!validation.isEmpty(agreement)) {
         Property property = new Property(customer, type, filter, block, dateOfOwnership, currentDate, size, demand, variation, address, agreement, isResidential, selectedCharacteristic, selectedServices, selectedImagesLinks);
         if (propertyManager.addProperty(property)) {
         dialog.show("Property Successfully Added");
         } else {
         dialog.show("Property Already Exist");
         }
         } else {
         dialog.show("Please specify Agreement");
         }
         } else {
         dialog.show("Please specify Address");
         }
         */
    }//GEN-LAST:event_btnAddPropertyActionPerformed

    private void tblImagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImagesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblImagesMouseClicked

    private void btnRemoveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveImageActionPerformed
        // TODO add your handling code here:
        int index = tblImages.getSelectedRow();
        if (index >= 0) {
            selectedImagesLinks.remove(index);
            model = (DefaultTableModel) tblImages.getModel();
            model.removeRow(index);
        } else {
            dialog.show("Please Select a row");
        }
    }//GEN-LAST:event_btnRemoveImageActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg");
        fileChoser.setFileFilter(filter);
        if (fileChoser.showOpenDialog(fileChoser) == JFileChooser.APPROVE_OPTION) {
            String link = fileChoser.getSelectedFile().toString();
            model = (DefaultTableModel) tblImages.getModel();
            if (!selectedImagesLinks.contains(link)) {
                model.insertRow(tblImages.getRowCount(), new Object[]{link});
                selectedImagesLinks.add(link);
            } else {
                dialog.show("Image Already Added");
            }
        }
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void cmbCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomersActionPerformed

    private void cmbPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropertiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPropertiesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCharacteristic;
    private javax.swing.JButton btnAddImage;
    private javax.swing.JButton btnAddProperty;
    private javax.swing.JButton btnRemoveCharacteristic;
    private javax.swing.JButton btnRemoveImage;
    private javax.swing.JButton btnReset;
    private javax.swing.JCheckBox chkIsResidential;
    private javax.swing.JComboBox cmbAreas;
    private javax.swing.JComboBox cmbBlocks;
    private javax.swing.JComboBox cmbCharacteristics;
    private javax.swing.JComboBox cmbCustomers;
    private javax.swing.JComboBox cmbProperties;
    private javax.swing.JComboBox cmbPropertyFilter;
    private javax.swing.JComboBox cmbPropertyType;
    private javax.swing.JFileChooser fileChoser;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddPropertyError;
    private javax.swing.JList lstServices;
    private javax.swing.JSpinner spinDate;
    private javax.swing.JSpinner spinDemand;
    private javax.swing.JSpinner spinNoOfRooms;
    private javax.swing.JSpinner spinQuantity;
    private javax.swing.JSpinner spinSize;
    private javax.swing.JSpinner spinVariation;
    private javax.swing.JTable tblCharacteristics;
    private javax.swing.JTable tblImages;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtAgreement;
    // End of variables declaration//GEN-END:variables

    private void createCheckBoxList() {
        serviceList = propertyManager.getPropertyServices();
        int length = serviceList.size();
        CheckListItem[] listOfSheets = new CheckListItem[length];
        int i = 0;
        while (i < length) {
            String name = serviceList.get(i).getServiceName();
            listOfSheets[i] = new CheckListItem(name);
            i++;
        }
        lstServices.setListData(listOfSheets);
    }

    class CheckListRenderer extends JCheckBox
            implements ListCellRenderer {

        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean hasFocus) {
            setEnabled(list.isEnabled());
            setSelected(((CheckListItem) value).isSelected());
            setFont(list.getFont());
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            setText(value.toString());
            return this;
        }
    }

    class CheckListItem {

        private String label;
        private boolean isSelected = false;

        public CheckListItem(String label) {
            this.label = label;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean isSelected) {
            this.isSelected = isSelected;
        }

        public String toString() {
            return label;
        }
    }
}
