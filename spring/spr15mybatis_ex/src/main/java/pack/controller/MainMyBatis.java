package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainMyBatis {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("dbinit.xml");
		
		BusinessInter businessInter =(BusinessInter)context.getBean("businessImpl");
		businessInter.dataShow();
	}

}
