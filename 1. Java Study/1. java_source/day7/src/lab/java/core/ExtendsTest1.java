package lab.java.core;

class Parent {
    String name = "parent";
    private int money =1000000000;
    public void work() {
    	System.out.println("IT");
    }
    private void hobby() {
    	System.out.println("2Job");
    }
}

class Child extends Parent{ //»ó¼Ó
	
}

public class ExtendsTest1 {
	public static void main(String[] args) {
		Child c1 = new Child();
		System.out.println(c1.name);
		c1.name = "child";
		System.out.println(c1.name);
		c1.work();		
	}
}