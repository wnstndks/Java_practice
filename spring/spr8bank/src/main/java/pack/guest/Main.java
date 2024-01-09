package pack.guest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//	Annotation 연습용

		ApplicationContext context= new ClassPathXmlApplicationContext("annobank.xml");

		Gogek god =(Gogek)context.getBean("gogek");
		god.selectBank("sinhan");
		god.playInputMoney(50000);
		god.playOutputMoney(5000);
		System.out.println("god-");
		god.showMoney();
		
		
		Gogek god2 =(Gogek)context.getBean("gogek");
		god2.selectBank("hana");
		god2.playInputMoney(500000);
		god2.playOutputMoney(50000);
		System.out.println("god2-");
		god2.showMoney();
		
		
		Gogek god3 =(Gogek)context.getBean("gogek");
		god3.selectBank("hana");
		god3.playInputMoney(5000000);
		god3.playOutputMoney(500000);
		System.out.println("god3-");
		god3.showMoney();
	
		System.out.println("주소 확인 :"+god+" "+god3);
	}
}
