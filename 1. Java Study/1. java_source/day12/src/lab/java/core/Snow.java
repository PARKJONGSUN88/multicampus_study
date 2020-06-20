package lab.java.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
 

public class Snow extends Panel implements Runnable {
    int x, y;
    public Snow() {
    	setSize(200,200);
    	setBackground(Color.BLACK);    	
    }
    
    public void paint(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillOval(x, y, 5, 5);     	 
    }
    
    public void update(Graphics g) {
    	paint(g);
    }
    
	@Override
	public void run() {
		while(true) {
			x=(int)(Math.random()*200);
			y=(int)(Math.random()*200);
			repaint();
			try {
			Thread.sleep(300);
			}catch(InterruptedException e) {
				
			}
		}
		
	}
   
}
