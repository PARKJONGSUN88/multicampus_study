package lab.spring.di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lab.spring.di.service.HelloService;

public class AnnotationDITest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		HelloService service =
				context.getBean("hello", HelloService.class);
		service.sayHello();

	}

}
