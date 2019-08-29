/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceLayer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

class ImageObj extends Component 
	{
		BufferedImage img;
		
		//Every object has dimentions...we define our dimentions (for our object)
		 public Dimension getPreferredSize() {
        if (img == null) {
	           return new Dimension(100,100);
        } else {
	         return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
		ImageObj(BufferedImage imgObj)
		{
			//todo: 
			//copy all data to local object (not just pointer)...
                   // img = ImageIO.read(imgObj);			
		}
		
		ImageObj(final String filename)
		{
			try {
				img = ImageIO.read(new File(filename));
				}catch(Exception e)
				{
					System.out.println("Exception: "+e);
				}
		}

		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
		
		public BufferedImage getImageData()
		{
			return img;
		}
	}
	