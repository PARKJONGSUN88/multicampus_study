package lab.java.core;

import java.awt.Color;
import java.awt.Frame;

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
	}
}
public class ConstructorTest2 {
	public static void main(String[] args) {
		MyFrame f1 = new MyFrame();
		MyFrame f2 = new MyFrame(200,200);
		MyFrame f3 = new MyFrame(300,300, Color.blue);
	}
}
