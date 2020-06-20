package lab.java.core;
import java.io.*; 
public class FileInputStreamEx{ 
	public static void main(String arg[]){ 
		FileInputStream fis = null; 
		byte _read[] = new byte[100]; 
		byte console[] = new byte[100]; 
		try{ 
			System.out.print("파일명 : "); 
			System.in.read(console); //파일경로이름 입력
			String file = new String(console).trim(); 
			fis = new FileInputStream(file); 
			fis.read(_read,0,_read.length); 
			System.out.println(new String(_read).trim()); 
		}catch(FileNotFoundException fnfe){ 
			fnfe.printStackTrace(); 
		}catch(IOException ie){ 
			ie.printStackTrace(); 
		}finally{ 
			try{ 
				if(fis != null) fis.close(); 
			}catch(IOException ioe){ 
				ioe.printStackTrace(); 
			} 
		}//finally end 
	} //main end
}//class end
