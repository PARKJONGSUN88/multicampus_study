package exercise.overall.processor;

public abstract class Processor {
   public String name() {
         return getClass().getSimpleName();	   
   }
   protected abstract Object process(Object input);
   
}
