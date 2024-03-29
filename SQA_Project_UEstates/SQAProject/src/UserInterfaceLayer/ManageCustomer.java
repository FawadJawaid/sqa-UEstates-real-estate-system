/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import javax.swing.JTabbedPane;

/**
 *
 * @author arsalan
 */
public class ManageCustomer extends javax.swing.JPanel {

    AddCustomer addCustomer = new AddCustomer();
    UpdateCustomer updateCustomer = new UpdateCustomer();
    ViewCustomers viewCustomer = new ViewCustomers();

    /**
     * Creates new form Customer
     */
    public ManageCustomer() {
        initComponents();
        customerTabBar.add(addCustomer, "Add Customer");
        customerTabBar.add(updateCustomer, "Update Customer");
        customerTabBar.add(viewCustomer, "View Customers");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerTabBar = new javax.swing.JTabbedPane();

        customerTabBar.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        customerTabBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                customerTabBarStateChanged(evt);
            }
        });
        customerTabBar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                customerTabBarPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(customerTabBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(customerTabBar, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void customerTabBarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_customerTabBarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_customerTabBarPropertyChange

    private void customerTabBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_customerTabBarStateChanged
        // TODO add your handling code here:

        JTabbedPane sourceTabbedPane = (JTabbedPane) evt.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        switch (index) {
            case 1:
                updateCustomer.updateDropDownValues();
                break;
            case 2:
                viewCustomer.updateCustomersTable();
                break;
        }
    }//GEN-LAST:event_customerTabBarStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane customerTabBar;
    // End of variables declaration//GEN-END:variables

}
