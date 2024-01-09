package anno2_resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		//	Resource 연습용
		// configuration 파일이 복수인 경우
		
		String[] metas= new String[] {"anno2.xml"}; //{"anno2.xml","..."}
		ApplicationContext context= new ClassPathXmlApplicationContext(metas[0]);
		
		AbcProcess process=context.getBean("ap",AbcProcess.class);
		process.showData();
	}
}
