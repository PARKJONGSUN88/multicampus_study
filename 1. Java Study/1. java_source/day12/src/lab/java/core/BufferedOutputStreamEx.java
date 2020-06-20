package lab.java.core;
import java.io.*; 
public class BufferedOutputStreamEx { 
	public static void main(String[] args){ 
		FileOutputStream fos = null; 
		BufferedOutputStream bos = null; 
		try { 
			fos = new FileOutputStream("c:/test/bufferOut.txt");
			bos = new BufferedOutputStream(fos); 
			String str = "BufferedOutputStream Test ¿‘¥œ¥Ÿ."; 
			bos.write(str.getBytes()); 
			bos.flush(); 
		} catch (IOException ie) { 
			ie.printStackTrace(); 
		} finally { 
			try { 
				if (fos != null) fos.close(); 
				if (bos != null) bos.close(); 
			} catch (IOException ioe) { 
				ioe.printStackTrace(); 
			} 
		} 
	} 
}
