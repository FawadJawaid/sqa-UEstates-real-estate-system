/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import BusinessLogicLayer.Customer;
import BusinessLogicLayer.DataManager;
import BusinessLogicLayer.Validations;
import java.util.ArrayList;

/**
 *
 * @author arsalan
 */
public class UpdateCustomer extends javax.swing.JPanel {

    private Validations validation;
    private DataManager dataManager;
    private ArrayList<Customer> customers;
    private DialogBox dialog;

    /**
     * Creates new form UpdateCustomer
     */
    public UpdateCustomer() {
        initComponents();
        validation = new Validations();
        dataManager = DataManager.getInstance();
        dialog = new DialogBox();
        updateDropDownValues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        txtPhn_Update = new javax.swing.JTextField();
        txtName_Update = new javax.swing.JTextField();
        btnUpdateCustomer = new javax.swing.JButton();
        txtCnic_Update = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        chkUpdateCustomer = new javax.swing.JComboBox();
        lblUpdateCustomerError = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress_Update = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel12.setLayout(null);

        txtPhn_Update.setToolTipText("Enter Customer Phone Number. Format: 03xxxxxxxx");
        txtPhn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhn_UpdateActionPerformed(evt);
            }
        });
        jPanel12.add(txtPhn_Update);
        txtPhn_Update.setBounds(390, 180, 370, 30);

        txtName_Update.setToolTipText("Enter Customer Name");
        txtName_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName_UpdateActionPerformed(evt);
            }
        });
        jPanel12.add(txtName_Update);
        txtName_Update.setBounds(390, 140, 370, 30);

        btnUpdateCustomer.setText("Update");
        btnUpdateCustomer.setToolTipText("Update Employee Information");
        btnUpdateCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });
        jPanel12.add(btnUpdateCustomer);
        btnUpdateCustomer.setBounds(510, 440, 130, 40);

        txtCnic_Update.setToolTipText("Enter Customer CNIC. Format: xxxxx-xxxxxxx-x");
        txtCnic_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnic_UpdateActionPerformed(evt);
            }
        });
        jPanel12.add(txtCnic_Update);
        txtCnic_Update.setBounds(390, 220, 370, 30);

        jLabel26.setText("Select Employee Id to be Updated: ");
        jPanel12.add(jLabel26);
        jLabel26.setBounds(310, 90, 220, 30);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setText("UPDATE CUSTOMER");
        jPanel12.add(jLabel50);
        jLabel50.setBounds(480, 20, 280, 50);

        chkUpdateCustomer.setToolTipText("Select Employee ID");
        chkUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUpdateCustomerActionPerformed(evt);
            }
        });
        jPanel12.add(chkUpdateCustomer);
        chkUpdateCustomer.setBounds(500, 90, 260, 30);

        lblUpdateCustomerError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel12.add(lblUpdateCustomerError);
        lblUpdateCustomerError.setBounds(380, 400, 380, 30);

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update emp.png"))); // NOI18N
        jPanel12.add(jLabel67);
        jLabel67.setBounds(410, 10, 70, 70);

        txtAddress_Update.setColumns(20);
        txtAddress_Update.setRows(5);
        txtAddress_Update.setToolTipText("Enter Customer Address");
        jScrollPane2.setViewportView(txtAddress_Update);

        jPanel12.add(jScrollPane2);
        jScrollPane2.setBounds(390, 260, 370, 130);

        jLabel7.setText("Enter Address");
        jPanel12.add(jLabel7);
        jLabel7.setBounds(300, 260, 90, 30);

        jLabel49.setText("Enter CNIC");
        jPanel12.add(jLabel49);
        jLabel49.setBounds(310, 220, 70, 30);

        jLabel8.setText("Enter Phone Number");
        jPanel12.add(jLabel8);
        jLabel8.setBounds(270, 180, 120, 30);

        jLabel6.setText("Enter Name");
        jPanel12.add(jLabel6);
        jLabel6.setBounds(310, 140, 70, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1054, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhn_UpdateActionPerformed
        // TODO add your handling code here:
        txtPhn_Update.nextFocus();
    }//GEN-LAST:event_txtPhn_UpdateActionPerformed

    private void txtName_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName_UpdateActionPerformed
        // TODO add your handling code here:
        txtName_Update.nextFocus();
    }//GEN-LAST:event_txtName_UpdateActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        updateCustomer();
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void txtCnic_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnic_UpdateActionPerformed
        // TODO add your handling code here:
        txtCnic_Update.nextFocus();
    }//GEN-LAST:event_txtCnic_UpdateActionPerformed

    private void chkUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUpdateCustomerActionPerformed
        // TODO add your handling code here:
        dropdownValueChanged();
    }//GEN-LAST:event_chkUpdateCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JComboBox chkUpdateCustomer;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUpdateCustomerError;
    private javax.swing.JTextArea txtAddress_Update;
    private javax.swing.JTextField txtCnic_Update;
    private javax.swing.JTextField txtName_Update;
    private javax.swing.JTextField txtPhn_Update;
    // End of variables declaration//GEN-END:variables

    /**
     * Function to update customer
     */
    private void updateCustomer() {
        String name = txtName_Update.getText();
        String address = txtAddress_Update.getText();
        String phnNo = txtPhn_Update.getText();
        String cnic = txtCnic_Update.getText();

        if (!validation.isEmpty(name)) {
            if (!validation.isEmpty(address)) {
                if (validation.isValidPhoneNo(phnNo)) {
                    if (validation.isValidCnic(cnic)) {
                        Customer customer = customers.get(chkUpdateCustomer.getSelectedIndex());
                        customer.setName(name);
                        customer.setAddress(address);
                        customer.setNumber(phnNo);
                        customer.setCnic(cnic);
                        if (dataManager.getCustomerManager().updateCustomer(customer)) {
                            clearValues();
                            updateDropDownValues();
                            dialog.show("Customer Successfully Updated");
                            lblUpdateCustomerError.setText("");
                        } else {
                            dialog.show("Customer Already Exists");
                            lblUpdateCustomerError.setText("Customer Already Exists");
                        }
                    } else {
                        dialog.show("Invalid CNIC Format. Format: xxxxx-xxxxxxx-x");
                        lblUpdateCustomerError.setText("Invalid CNIC Format. Format: xxxxx-xxxxxxx-x");
                    }
                } else {
                    dialog.show("Wrong Phnone No. Format: 03xxxxxxxxx");
                    lblUpdateCustomerError.setText("Wrong Phnone No. Format: 03xxxxxxxxx");
                }
            } else {
                dialog.show("Please Specify Address.");
                lblUpdateCustomerError.setText("Please Specify Address.");
            }
        } else {
            dialog.show("Please Specify Name");
            lblUpdateCustomerError.setText("Please Specify Name");
        }
    }

    /**
     * Function to update dropdown values
     */
    public void updateDropDownValues() {
        customers = dataManager.getCustomerManager().getCustomers();
        chkUpdateCustomer.removeAllItems();
        if (customers.size() > 0) {
            enableUpdate();
            Customer customer;

            for (int i = 0; i < customers.size(); i++) {
                customer = customers.get(i);
                chkUpdateCustomer.addItem(customer.getName());
            }
        } else {
            disableUpdate();
        }
    }

    /**
     * Function to cater dropdown value changed
     */
    private void dropdownValueChanged() {
        int index = chkUpdateCustomer.getSelectedIndex();
        if (index >= 0) {
            Customer customer = customers.get(index);
            txtName_Update.setText(customer.getName());
            txtAddress_Update.setText(customer.getAddress());
            txtPhn_Update.setText(customer.getNumber());
            txtCnic_Update.setText(customer.getCnic());
        }
    }

    /**
     * Function to disable update fields
     */
    private void disableUpdate() {
        txtName_Update.setEnabled(false);
        txtAddress_Update.setEnabled(false);
        txtPhn_Update.setEnabled(false);
        txtCnic_Update.setEnabled(false);
        btnUpdateCustomer.setEnabled(false);
    }

    /**
     * Function to enable update fields
     */
    private void enableUpdate() {
        txtName_Update.setEnabled(true);
        txtAddress_Update.setEnabled(true);
        txtPhn_Update.setEnabled(true);
        txtCnic_Update.setEnabled(true);
        btnUpdateCustomer.setEnabled(true);
    }

    /**
     * Function to clear field values
     */
    private void clearValues() {
        txtAddress_Update.setText("");
        txtCnic_Update.setText("");
        txtName_Update.setText("");
        txtPhn_Update.setText("");
    }
}
