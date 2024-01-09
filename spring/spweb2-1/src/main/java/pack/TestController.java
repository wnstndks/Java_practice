package pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//주로 사용자의 요청을 처리(모델을 경유) 한 후 지정된 뷰에 모델 객체를 전달하는 역할, 클라이언트 데이터 입출력을 제어하는 클래스
@Controller
public class TestController {
	
	//부트는 팩에서 부터 하위를 스캔하기 때문에 밑에서 부터 생성해야 한다.
	
	@RequestMapping("test1")
	public ModelAndView abc() {
		// BL 처리 또는 모델 영역을 수행하는 역할을 함
		System.out.println("abc 처리");
		
		return null;
	}
}
