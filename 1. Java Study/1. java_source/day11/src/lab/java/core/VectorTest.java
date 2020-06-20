package lab.java.core;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {		 
		Vector<String> vec = new Vector();
		System.out.println("capacity: "+vec.capacity());
		System.out.println("size: "+vec.size()); 
		for(int i=1;i<12;i++)
			vec.add("K"+i);
		System.out.println("capacity: "+vec.capacity());
		System.out.println("size: "+vec.size()); 
		for(int i=12;i<23;i++)
			vec.add("K"+i);
		System.out.println("capacity: "+vec.capacity());
		System.out.println("size: "+vec.size()); 
		for(int i=23;i<42;i++)
			vec.add("K"+i);
		System.out.println("capacity: "+vec.capacity());
		System.out.println("size: "+vec.size()); 
	}

}