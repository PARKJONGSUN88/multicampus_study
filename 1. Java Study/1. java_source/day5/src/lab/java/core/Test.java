package lab.java.core;

public class Test {   //Test this = new Test();
    private int num;
    public void setNum(int num) {//로컬변수
        //메소드를 호출한 객체 자신의 속성 num에 저장하기 위해서는 
    	//모든 객체는 생성될때 자기자신을 참조하는 reference변수 자동 생성됩니다.
     	this.num = num;
    }
    public int getNum() {
    	return num;
    }
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.getNum());//?0
		t.setNum(100);
		System.out.println(t.getNum());//?100
		
	}

}
