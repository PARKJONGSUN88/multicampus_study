package exercise.class2;

public class StudentTest {

	public static void main(String[] args) {
		Student[] students = new Student[4];
		students[0] = new Student("SW05A01", 80, 90, 100);
		students[1] = new Student("SW05A02", 70, 80, 90);
		students[2] = new Student("SW05A03", 90, 90, 100);
		students[3] = new Student("SW05A04", 90, 90, 90);
		
		for(int i=0;i<students.length;i++) {
			System.out.println("=== "+students[i].getStudentId()+" ÇÐ»ý Á¡¼ö ====");
			System.out.println(students[i].toString());
			System.out.println("ÃÑÁ¡: "+students[i].getTotal()+"Á¡");
			System.out.println("Æò±Õ: "+students[i].getTotal()/3+"Á¡");
		}
		
//		Student[] students2 = new Student[] {
//				new Student("SW05A01", 80, 90, 100),
//				new Student("SW05A02", 70, 80, 90),
//				new Student("SW05A03", 90, 90, 100),
//				new Student("SW05A04", 90, 90, 90)
//		};
		
//		 Student s1 =new Student("SW05A01", 80, 90, 100);
//		 System.out.println(s1);
//		System.out.print("C: "+s1.getC()+"Á¡,");
//		System.out.print(" Linux: "+s1.getLinux()+"Á¡,");
//		System.out.print(" Java: "+s1.getJava()+"Á¡\n");
	

	}

}
