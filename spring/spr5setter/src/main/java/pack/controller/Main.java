package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("myinit.xml");
		
		MyProcess myProcess =(MyProcess)context.getBean("my");
//		System.out.println(myProcess.displayData());
//		System.out.println(myProcess.toString());
		System.out.println(myProcess);
		
	}

}
