package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.setterex.MyProcessService;

@SpringBootApplication
public class Sprweb4thApplication {
	public static void main(String[] args) {
		//SpringApplication.run(Sprweb4thApplication.class, args).getBean(Sprweb4thApplication.class).myExecute();
		SpringApplication.run(Sprweb4thApplication.class, args);
	}

	@Autowired
	MyClass class1;

	private void myExecute() {
		System.out.println("금이팅");

		class1.aaa();

		//이전 setter 연습용 소스 실행
		ApplicationContext context = new ClassPathXmlApplicationContext("myinit.xml");

		MyProcessService service = (MyProcessService) context.getBean("myProcess");
		service.displayData();
	}
}
