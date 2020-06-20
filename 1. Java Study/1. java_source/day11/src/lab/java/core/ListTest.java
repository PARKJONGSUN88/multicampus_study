package lab.java.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ListTest {

	public static void main(String[] args) {
		String cars[] = {"k3", "k5", "sm6","k7", "k9", "sm3", "k5","sm5", "sm6", "sm7"}; 
		List<String> alist = new ArrayList();
		for (String car : cars) {
			alist.add(car);
		}
		System.out.println(alist.size());
		System.out.println(alist);
		alist.set(1, "Bentz");
		System.out.println(alist);
		alist.remove(5);
		System.out.println(alist);
		System.out.println(alist.size());
		
		for(int i=0;i<alist.size();i++) {
			System.out.print(alist.get(i)+",");
		}
		System.out.println();
		Iterator<String> iter = alist.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+",");
		}
		//alist.iterator(), iter.hasNext(), iter.next()		
		System.out.println();
		 
	}

}
