/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import BusinessLogicLayer.*;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class AddProperty extends javax.swing.JPanel {

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
     * Creates new form AddProperty
     */
    public AddProperty() {
        initComponents();
        validation = new Validations();
        propertyManager = DataManager.getInstance().getPropertyManager();
        customerManager = DataManager.getInstance().getCustomerManager();
        selectedServices = new ArrayList<>();
        selectedCharacteristic = new ArrayList<>();
        selectedImagesLinks = new ArrayList<>();
        dialog = new DialogBox();
        lstServices.setCellRenderer(new CheckListRenderer());
        fillAllDropDown();
    }

    public void fillAllDropDown() {
        fillAreaDropDown();
        fillCustomerDropDown();
        fillPropertyForDropDown();
        fillPropertyTypeDropDown();
        fillPropertyCharacteristicDropDown();
        createCheckBoxList();
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

        jPanel10 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbCustomers = new javax.swing.JComboBox();
        cmbPropertyType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbCharacteristics = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbBlocks = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbPropertyFilter = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spinSize = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        spinDemand = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        spinVariation = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        spinQuantity = new javax.swing.JSpinner();
        chkIsResidential = new javax.swing.JCheckBox();
        spinDate = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstServices = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAgreement = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbAreas = new javax.swing.JComboBox();
        spinNoOfRooms = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCharacteristics = new javax.swing.JTable();
        btnRemoveCharacteristic = new javax.swing.JButton();
        btnAddCharacteristic = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnAddProperty = new javax.swing.JButton();
        lblAddPropertyError = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblImages = new javax.swing.JTable();
        btnRemoveImage = new javax.swing.JButton();
        btnAddImage = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        fileChoser = new javax.swing.JFileChooser();

        jPanel10.setLayout(null);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel59.setText("ADD PROPERTY");
        jPanel10.add(jLabel59);
        jLabel59.setBounds(410, 0, 340, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Owner");
        jPanel10.add(jLabel1);
        jLabel1.setBounds(70, 50, 70, 30);

        cmbCustomers.setToolTipText("Select Owner of Property");
        cmbCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomersActionPerformed(evt);
            }
        });
        jPanel10.add(cmbCustomers);
        cmbCustomers.setBounds(140, 50, 190, 30);

        cmbPropertyType.setToolTipText("Select Property Type");
        jPanel10.add(cmbPropertyType);
        cmbPropertyType.setBounds(140, 90, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Property Type");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(50, 90, 90, 30);

        cmbCharacteristics.setToolTipText("Select Characteristic of Property");
        jPanel10.add(cmbCharacteristics);
        cmbCharacteristics.setBounds(410, 230, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Area");
        jPanel10.add(jLabel3);
        jLabel3.setBounds(390, 50, 50, 30);

        cmbBlocks.setToolTipText("Select Block of Area for Property");
        jPanel10.add(cmbBlocks);
        cmbBlocks.setBounds(760, 50, 190, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Date of Ownership");
        jPanel10.add(jLabel4);
        jLabel4.setBounds(700, 90, 120, 30);

        cmbPropertyFilter.setToolTipText("Select Purpose of Property");
        cmbPropertyFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropertyFilterActionPerformed(evt);
            }
        });
        jPanel10.add(cmbPropertyFilter);
        cmbPropertyFilter.setBounds(440, 90, 220, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Property For");
        jPanel10.add(jLabel5);
        jLabel5.setBounds(350, 90, 80, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Address");
        jPanel10.add(jLabel6);
        jLabel6.setBounds(20, 200, 70, 30);

        spinSize.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(10), null, Integer.valueOf(1)));
        spinSize.setToolTipText("Select Size of Property ");
        jPanel10.add(spinSize);
        spinSize.setBounds(120, 140, 70, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Demand");
        jPanel10.add(jLabel7);
        jLabel7.setBounds(230, 140, 70, 30);

        spinDemand.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5000), Integer.valueOf(5000), null, Integer.valueOf(1000)));
        spinDemand.setToolTipText("Select Demand for Property");
        jPanel10.add(spinDemand);
        spinDemand.setBounds(300, 140, 110, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Property Images");
        jPanel10.add(jLabel8);
        jLabel8.setBounds(690, 230, 110, 30);

        spinVariation.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1000), Integer.valueOf(1000), null, Integer.valueOf(500)));
        spinVariation.setToolTipText("Select Variation in Demand");
        jPanel10.add(spinVariation);
        spinVariation.setBounds(520, 140, 90, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Number of Rooms");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(640, 140, 110, 30);

        spinQuantity.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        spinQuantity.setToolTipText("Select Quantity of Characteristic");
        jPanel10.add(spinQuantity);
        spinQuantity.setBounds(550, 230, 50, 30);

        chkIsResidential.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chkIsResidential.setText("Residential");
        chkIsResidential.setToolTipText("Is Property Residential?");
        jPanel10.add(chkIsResidential);
        chkIsResidential.setBounds(850, 140, 100, 30);

        spinDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.YEAR));
        spinDate.setToolTipText("Select Date of ownership");
        jPanel10.add(spinDate);
        spinDate.setBounds(820, 90, 130, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Block");
        jPanel10.add(jLabel10);
        jLabel10.setBounds(700, 50, 60, 30);

        lstServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstServicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstServices);

        jPanel10.add(jScrollPane1);
        jScrollPane1.setBounds(270, 230, 130, 220);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Size in Sq Ft");
        jPanel10.add(jLabel11);
        jLabel11.setBounds(30, 140, 90, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Characteristics");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(410, 200, 130, 30);

        txtAgreement.setColumns(20);
        txtAgreement.setRows(5);
        jScrollPane2.setViewportView(txtAgreement);

        jPanel10.add(jScrollPane2);
        jScrollPane2.setBounds(20, 350, 240, 100);

        txtAddress.setColumns(20);
        txtAddress.setRows(4);
        txtAddress.setToolTipText("Enter Property Address");
        jScrollPane3.setViewportView(txtAddress);

        jPanel10.add(jScrollPane3);
        jScrollPane3.setBounds(20, 230, 240, 90);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Agreement");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(20, 320, 100, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Services");
        jPanel10.add(jLabel14);
        jLabel14.setBounds(270, 200, 90, 30);

        cmbAreas.setToolTipText("Select Area of Property");
        cmbAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreasActionPerformed(evt);
            }
        });
        jPanel10.add(cmbAreas);
        cmbAreas.setBounds(440, 50, 220, 30);

        spinNoOfRooms.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinNoOfRooms.setToolTipText("Select Number of rooms");
        jPanel10.add(spinNoOfRooms);
        spinNoOfRooms.setBounds(750, 140, 70, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Variation");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(450, 140, 70, 30);

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
        jScrollPane4.setViewportView(tblCharacteristics);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(410, 270, 270, 150);

        btnRemoveCharacteristic.setText("Remove Characteristic");
        btnRemoveCharacteristic.setToolTipText("Remove Characteristic");
        btnRemoveCharacteristic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveCharacteristic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCharacteristicActionPerformed(evt);
            }
        });
        jPanel10.add(btnRemoveCharacteristic);
        btnRemoveCharacteristic.setBounds(510, 420, 170, 30);

        btnAddCharacteristic.setText("Add");
        btnAddCharacteristic.setToolTipText("Add Characteristic");
        btnAddCharacteristic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCharacteristic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCharacteristicActionPerformed(evt);
            }
        });
        jPanel10.add(btnAddCharacteristic);
        btnAddCharacteristic.setBounds(610, 230, 60, 30);

        btnReset.setText("Reset");
        btnReset.setToolTipText("Reset Values");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.add(btnReset);
        btnReset.setBounds(360, 460, 110, 30);

        btnAddProperty.setText("Add Property");
        btnAddProperty.setToolTipText("Add Property");
        btnAddProperty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPropertyActionPerformed(evt);
            }
        });
        jPanel10.add(btnAddProperty);
        btnAddProperty.setBounds(500, 460, 120, 30);

        lblAddPropertyError.setText("Property Already Exists");
        jPanel10.add(lblAddPropertyError);
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
        jScrollPane5.setViewportView(tblImages);

        jPanel10.add(jScrollPane5);
        jScrollPane5.setBounds(690, 270, 270, 150);

        btnRemoveImage.setText("Remove Image");
        btnRemoveImage.setToolTipText("Remove Image");
        btnRemoveImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveImageActionPerformed(evt);
            }
        });
        jPanel10.add(btnRemoveImage);
        btnRemoveImage.setBounds(790, 420, 170, 30);

        btnAddImage.setText("Add Image");
        btnAddImage.setToolTipText("Add Image");
        btnAddImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });
        jPanel10.add(btnAddImage);
        btnAddImage.setBounds(850, 230, 110, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Quantity");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(540, 200, 70, 30);
        jPanel10.add(jSeparator1);
        jSeparator1.setBounds(0, 190, 1040, 20);
        jPanel10.add(fileChoser);
        fileChoser.setBounds(10, 10, 10, 10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreasActionPerformed
        // TODO add your handling code here:
        fillBlockDropDown();
    }//GEN-LAST:event_cmbAreasActionPerformed

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

    private void btnAddPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPropertyActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_btnAddPropertyActionPerformed

    private void cmbCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomersActionPerformed

    private void cmbPropertyFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropertyFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPropertyFilterActionPerformed


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
    private javax.swing.JComboBox cmbPropertyFilter;
    private javax.swing.JComboBox cmbPropertyType;
    private javax.swing.JFileChooser fileChoser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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
