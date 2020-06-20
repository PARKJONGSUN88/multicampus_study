package lab.java.core;
import java.io.*; 
public class FileCopyEx{ 
	public static void main(String args[]){ 
		FileInputStream fis = null; 
		FileOutputStream fos = null; 
		int _byte = 0;
		try{ 			  
			fis = new FileInputStream(args[0]); 
			fos = new FileOutputStream(args[1]);
			while((_byte=fis.read())!=-1){ 
			    fos.write(_byte); 
			}
			System.out.println("복사 완료!!!!");
		}catch(IOException ie){ 
			ie.printStackTrace(); 
		}finally{ 
			try{ 
				if(fos != null) fos.close();
				if(fis != null) fis.close(); 
			}catch(IOException ioe){ 
				ioe.printStackTrace(); 
			} 
		}//finally end 
	} //main end
}//class end
