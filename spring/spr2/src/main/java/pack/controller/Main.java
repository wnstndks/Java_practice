package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.DataDao;
import pack.model.DataDaoImpl;

public class Main {

	public static void main(String[] args) {
		// 전통적인 방법
		// db 처리용
		DataDaoImpl daoImpl = new DataDaoImpl();
		DataDao dataDao =daoImpl;
		
		//비즈니스 처리용
		BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl(dataDao);
		BusinessService businessService = businessServiceImpl;
		businessService.selectProcess();
		
		System.out.println("-------------");
		
		//spring의 방법 : 환경설정(Configuration) 파일(xml)을 이용
		// 모든 객체 설정을 자바로부터 분리, 외부화 할 수 있다.
		//spring은 설정팡일에서 예를들어 init.xml 설정된 내용을 읽어 application에서 필요한 기능을 처리한다
		//root tag는 <beans>다
//		<beans>태그로 주입할 객체를 설정파일에 설정한다
//		<beans> 속성으로 id: 객체변수명(중복불가), name:복수의 이름 지정 가능
		
		/*
		 * xml 파일로 설정됨
		//ApplicationContext context= new ClassPathXmlApplicationContext("init.xml");
		ApplicationContext context= new ClassPathXmlApplicationContext("classpath:init.xml");
		//ApplicationContext context= new ClassPathXmlApplicationContext("classpath:pack/contoller/init.xml");
		BusinessService businessService2 =(BusinessService)context.getBean("businessServiceImpl");
		businessService2.selectProcess();
		*/
		
		//자바 파일로 설정
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		BusinessService businessService2 =(BusinessService)context.getBean("businessServiceImpl");
		businessService2.selectProcess();
				
		
	}

}
