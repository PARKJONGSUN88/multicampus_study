package exercise.overall.processor;

public class LowerCase extends Processor {

	@Override
	protected Object process(Object input) {
		
		return ((String)input).toLowerCase();
	}

}
