package exercise.overall.processor;

public class ProcessTest {

	public static void main(String[] args) {
		Processor[] processors = new Processor[] {
				new LowerCase(),
				new UpperCase(),
				new Splitter()
		};
		String str = "I'm so sorry, but I love you, 다 거짓말~~";
		process(processors, str);

	}
	private static void process(Processor[] processors, String s) {		
		for (Processor p : processors) {
			System.out.println("Processor 명 : "+p.name());
			System.out.println("결과 출력 : "+p.process(s));
		}
	}

}
