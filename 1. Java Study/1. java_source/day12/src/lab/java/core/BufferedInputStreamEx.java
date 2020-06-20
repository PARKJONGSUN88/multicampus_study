package lab.java.core;
import java.io.*; 
public class BufferedInputStreamEx { 
	public static void main(String[] args){ 
		FileInputStream fis = null; 
		BufferedInputStream bis = null; 
		try{ 
			fis = new FileInputStream("c:/test/bufferIn.txt"); 
			bis = new BufferedInputStream(fis); 
			int readbyte=0; 
			while((readbyte = bis.read()) != -1) { 
				System.out.print((char)readbyte); 
			} 
		}catch(IOException ioe){ 
			ioe.printStackTrace(); 
		}finally{
			try{ 
				if(fis != null) fis.close(); 
				if(bis != null) bis.close(); 
			}catch(IOException ioe){ 
				ioe.printStackTrace(); 
			} 
		} 
	} 
} 
