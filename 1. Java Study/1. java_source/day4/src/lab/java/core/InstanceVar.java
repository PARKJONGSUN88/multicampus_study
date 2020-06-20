package lab.java.core;

public class InstanceVar {
    int a = 100;
	public static void main(String[] args) {
		InstanceVar iv = new InstanceVar();
		System.out.println(iv.a);//?100
		iv.a /=5;
		System.out.println(iv.a);//?20
		InstanceVar iv2 = new InstanceVar();
		System.out.println(iv2.a);//? 100
		iv.a %=5;
		System.out.println(iv2.a);//? 0
		iv = new InstanceVar();
		System.out.println(iv.a);//? 100
		iv.a /=50;
		System.out.println(iv.a);//? 2
	}

}
