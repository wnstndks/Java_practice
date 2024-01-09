package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 전통적 방법
		HelloMaven helloMaven = new HelloMaven();
		helloMaven.sayHello("홍길동");
		
		System.out.println();
		
		//spring을 사용 : IOC - 제어의 역전 : 객체관리를 spring이 함
		//xml을 부르기 init에서 썼잖아 위에거
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		HelloInter inter= (HelloInter)context.getBean("hello");
		inter.sayHello("한국인");
	}

}
