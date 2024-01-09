package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		//	Autowired 연습용

		ApplicationContext context= new ClassPathXmlApplicationContext("anno1.xml");
		//SenderProcess process=(SenderProcess)context.getBean("senderProcess");
		SenderProcess process=context.getBean("senderProcess",SenderProcess.class); //위와 같은 방법
		process.displayData();
//		process.getSender().show();
	}
}
