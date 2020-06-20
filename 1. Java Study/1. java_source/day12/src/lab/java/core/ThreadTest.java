package lab.java.core;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadTest extends Frame{
	Count cnt ;
	Snow snow;
	ThreadTest(){
		setSize(600, 200);
		setLayout(new GridLayout(1,3));
		cnt = new Count();
		add(cnt); //panel 컴포넌트를 frame에 배치
		snow = new Snow();
		add(snow);
		setVisible(true);
		
		
		addWindowListener(new WindowAdapter() {		
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Thread t = new Thread(cnt);
		t.start();  //스레드 시작 => 스케줄러 호출
		Thread t2 = new Thread(snow);
		t2.start();  //스레드 시작 => 스케줄러 호출
	}

	public static void main(String[] args) {
		new ThreadTest();

	}

}
