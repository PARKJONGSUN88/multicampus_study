package package2;

import package1.Parent;

public class Child extends Parent{
     public void access() {
    	 System.out.println(name);
    	 name="package2.child";
    	 System.out.println(name);
     }
}
