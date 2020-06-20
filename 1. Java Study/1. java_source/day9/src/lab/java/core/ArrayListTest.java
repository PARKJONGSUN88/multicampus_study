package lab.java.core;

import java.util.ArrayList;
import java.util.Iterator;

import com.workshop6.entity.Product;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Product> alist = new ArrayList();
		alist.add(new Product("사과", 1500));
		//alist.set(0, new Product("라면", 1000));
		alist.add(new Product("라면", 1000));
		for(int i=0;i<alist.size();i++) {
			System.out.println(alist.get(i).getName());
		}
		
		for(Product p : alist) {
			System.out.println(p.getName());
		}
		
		Iterator<Product> iterator = alist.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}

	}

}
