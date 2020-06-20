package lab.java.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class SetTest {

	public static void main(String[] args) {
		String cars[] = {"k3", "k5", "sm6","k7", "k9",  "sm3", "k5","sm5", "sm6", "sm7"}; 
		Set<String> hSet = new HashSet();
		Set<String> tSet = new TreeSet();
		for (String car : cars) {
			hSet.add(car);
			tSet.add(car);
		}
		
		Iterator<String> iter = hSet.iterator();
		System.out.print("HashSet :");
		while(iter.hasNext()) {
			System.out.print(iter.next()+",");
		}		
		System.out.println();
		
		iter = tSet.iterator();
		System.out.print("TreeSet :");
		while(iter.hasNext()) {
			System.out.print(iter.next()+",");
		}		
		System.out.println();
		
		
		 
	}

}
