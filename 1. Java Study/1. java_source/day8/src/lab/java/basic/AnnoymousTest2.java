package lab.java.basic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyFrame {
	public MyFrame() {
		Frame f = new Frame();
		f.setSize(100,100);
		f.setBackground(Color.black);
		f.setVisible(true);
	}
	public MyFrame(int w, int h) {
		Frame f = new Frame();
		f.setSize(w, h);
		f.setBackground(Color.yellow);
		f.setVisible(true);
	}
	public MyFrame(int w, int h, Color c) {
		Frame f = new Frame();
		f.setSize(w, h);
		f.setBackground(c);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				super.windowClosing(e);
				System.exit(0);
			}		
		});
	}
}
public class AnnoymousTest2 {
	public static void main(String[] args) {
		MyFrame f1 = new MyFrame();
		MyFrame f2 = new MyFrame(200,200);
		MyFrame f3 = new MyFrame(300,300, Color.blue);
	}
}
