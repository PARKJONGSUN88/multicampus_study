package lab.java.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
 

public class Count extends Panel implements Runnable {
    int num =0;
    public Count() {
    	setSize(200,200);
    }
    
    public void paint(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.setFont(new Font("ArialBlack", Font.BOLD|Font.ITALIC, 75));
    	g.drawString(String.valueOf(num), 100, 100 );
    }
    
	@Override
	public void run() {
		while(true) {
			num++;
			repaint();
			try {
			Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
		
	}
   
}
