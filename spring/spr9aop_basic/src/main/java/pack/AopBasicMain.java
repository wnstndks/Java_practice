package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopBasicMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aopinit.xml");
		
		//AOP 적용전
		//MessageInter inter = (MessageInter)context.getBean("targetObj");
		//inter.sayHi();
		
		//AOP 적용후
		MessageInter inter = (MessageInter)context.getBean("proxy");
		inter.sayHi();
		
		
	}

}
