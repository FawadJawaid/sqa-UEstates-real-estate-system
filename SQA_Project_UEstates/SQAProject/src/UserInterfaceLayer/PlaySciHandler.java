/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author fawad
 */
public class PlaySciHandler implements ActionListener  {
    
    JPanel panel;
    PlaySciHandler(JPanel p)
    {
         panel = p;
    }
    public void actionPerformed(ActionEvent ae)   
    {
      ImageIcon rock1 = new ImageIcon("rock.jpg");
      JLabel picture = new JLabel(rock1);
      picture.setBounds(60, 200, 400, 400);
      panel.add(picture);   
    } 
}
