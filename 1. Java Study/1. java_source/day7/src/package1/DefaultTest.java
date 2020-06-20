package package1;


class Other {
     public void access() {
    	 Parent p = new Parent();
    	 System.out.println(p.name);//속성 읽기
    	 p.name= "other";//속성값 변경
    	 System.out.println(p.name);//속성 읽기
     }
}

public class DefaultTest{
	public static void main(String[] args) {
	Other o = new Other();
	o.access();
	Child c = new Child();
	c.access();
	}
}





