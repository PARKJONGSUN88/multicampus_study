package exercise.overall.processor;

import java.util.Arrays;

public class Splitter extends Processor {

	@Override
	protected Object process(Object input) {
		String[] strings = ((String)input).split(" ");
		String resultString = Arrays.toString(strings);
		return resultString;
		
		//return  Arrays.toString(((String)input).split(" "));
	}

}
