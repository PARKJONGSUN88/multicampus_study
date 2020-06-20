package lab.java.core;
import java.io.*; 
public class FileOutputStreamEx{ 
	public static void main(String arg[])	{ 
		FileOutputStream fos = null; 
		try{ 
			File f = new File("c:/test");
			if(!f.exists())
				f.mkdirs();
			fos = new FileOutputStream("c:/test/fileout.txt"); 
			// fos = new FileOutputStream("c:/workspace/fileout.txt",true); 
			String message = "Hello FileOutputStream!!"; 
			fos.write(message.getBytes());
			System.out.println("file 쓰기 완료!!!");
		}catch(FileNotFoundException fnfe){ 
			fnfe.printStackTrace(); 
		}catch(IOException ie){ 
			ie.printStackTrace(); 
		}finally{ 
			try{ 
				if(fos != null) fos.close(); 
			}catch(IOException ioe){ 
				ioe.printStackTrace(); 
			} 
		} 
	} 
} 
