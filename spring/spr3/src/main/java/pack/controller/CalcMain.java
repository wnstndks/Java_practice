package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {

		ApplicationContext context= new ClassPathXmlApplicationContext("myinit.xml"); //xml에 만든 컨텐츠를 불러올때 applicationcontext를 불러오면 됨
		
		
		MyServiceInter inter=(MyServiceInter)context.getBean("myService");
		inter.inputMoney();
		inter.showMoney();
	}

}
