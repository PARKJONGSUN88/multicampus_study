package lab.java.core;
import java.io.*; 
public class RandomAccessFileEx { 
	public static void main(String[] args) { 
		RandomAccessFile ra = null; 
		try { 
			ra = new RandomAccessFile("c:/test/random.txt" , "rw" ); 
			String receive = " hello" ; 
			ra.seek(ra.length()); //0 offset
			ra.write(receive.getBytes()); 
			byte[] buf = new byte[(int) ra.length()]; 
			ra.seek(0); 
			ra.read(buf); 
			System.out.print(" 처음 읽은 내용 : " ); 
			System.out.println(new String(buf)); 
			ra.seek(0);
			receive = "안녕하세요?" ;
			ra.write(receive.getBytes()); 
			ra.seek(0);
			ra.read(buf); 
			System.out.print(" 다시 읽은 내용 : " ); 
			System.out.println(new String(buf)); 
		} catch (IOException ioe) { 
			ioe.printStackTrace(); 
		} finally { 
			try { 
				if (ra != null) ra.close(); 
			} catch (IOException ioe) { 
				ioe.printStackTrace(); 
			} 
		} 
	} 
}
