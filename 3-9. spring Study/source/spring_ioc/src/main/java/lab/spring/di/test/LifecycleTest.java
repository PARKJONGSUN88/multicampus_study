package lab.spring.di.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import lab.spring.di.service.HelloService;

public class LifecycleTest {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("application.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		String beanName = "service";
		HelloService service =
				beanFactory.getBean("service", HelloService.class);
		service.sayHello();
		beanFactory.removeBeanDefinition(beanName);
		

	}

}
