package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component //단순하게 객체를 생성
//@Service("senderProcess") //비즈니스 수행을 위해 만들어둔 클래스, 그래서 이름을 달리 해준 것
//똑같이 component가 벌어지지만 가독성 때문에 서비스라고 준것 Senderprocess와 하는 일이 다름
// db와 연동해서 처리하기 위해 만든 클래스

@Service //scope 안적어주면 singleton, 한번만 만들어지는 것
public class SenderProcess {
	//@Autowired //타입에 의한 매핑 :클래스에 포함관계
	//private Sender sender; // ->이렇게 써줘도 setter을 통해 여기에 매핑됨 밑에 setter 쓴것과같은 뜻
	
	@Autowired
//	@Qualifier("sender")
	@Qualifier("sender2")
	private SenderInter inter;
	
	
	/*
	@Autowired //method에 자동으로 sender 타입의 객체를 매핑
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	*/
	
	/*
	public Sender getSender() {
		return sender;
	}
	
	public void displayData() {
		sender.show();
	}
	*/
	
	public SenderInter getInter() {
		return inter;
	}
	public void displayData() {
		inter.show();
	}
	
}
