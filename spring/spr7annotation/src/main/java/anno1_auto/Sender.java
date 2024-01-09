package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component //Sender sender= new Sender(): 싱글톤으로 객체 생성
@Component("sender") //위와 가튼 말
//@Component("mysender") //위와 가튼 말
@Scope("singleton") //빈의 생존 범위 기본 값 "prototype", "request" , "session"

public class Sender implements SenderInter{ 
	public void show() {
		System.out.println("show method 수행");
	}
	
}
