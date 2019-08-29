/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author arsalan
 */
public class DialogBox {

    public void show(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
}
