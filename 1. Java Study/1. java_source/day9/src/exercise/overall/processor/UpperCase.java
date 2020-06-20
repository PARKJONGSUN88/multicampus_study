package exercise.overall.processor;

public class UpperCase extends Processor {

	@Override
	protected Object process(Object input) {		 
		return ((String)input).toUpperCase();
	}

}
