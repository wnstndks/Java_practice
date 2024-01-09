package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;


//주로 사용자의 요청을 처리(모델을 경유) 한 후 지정된 뷰에 모델 객체를 전달하는 역할, 클라이언트 데이터 입출력을 제어하는 클래스
@Controller
public class TestController {
	
	//부트는 팩에서 부터 하위를 스캔하기 때문에 밑에서 부터 생성해야 한다.
	
	@RequestMapping("test1") //dispatcherservlet으로부터 위임받은 handlermapping에 의해 처리
	public ModelAndView abc() {
		// BL 처리 또는 모델 영역을 수행하는 역할을 함
		System.out.println("abc 처리");
		
		
		
		//Model 인터페이스는 처리한 데이터를 뷰에 표시하기 위한 데이터를 전달. 내부적으로 HttpServletRequest 객체를 사용함
		//HttpServetRequest request=new HttpServetRequest();
		//request.setAttribute("msg","여긴어디나는누구");
		
		return new ModelAndView("list","msg","여긴어디나는누구");
		//DispatcherServlet으로부터 위임받음 viewResolver에 의해 처리
		
	}
	
	@RequestMapping(value="test2",method=RequestMethod.GET)
	public ModelAndView abc2() {
		return new ModelAndView("list","msg","여긴어디나는누구2");
		
	}
	
	@GetMapping("test3") //get 요청 처리용 전용 어노테이션
	public ModelAndView abc3() {
		return new ModelAndView("list","msg","여긴어디나는누구3");
	}
	
	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg","여긴어디나는누구4");
		return "list"; //모델 파라미터를 받고 리턴하면서 뷰 파일명만 적어주는 것 반환값은 스트링만 가져가는 것
	}
	
	@RequestMapping(value="test5",method=RequestMethod.POST)
	public ModelAndView abc5() {
		return new ModelAndView("list","msg","Post요청성공여긴어디나는누구5");
		
	}
	
	@PostMapping("test6") //postt 요청 처리용 전용 어노테이션
	public ModelAndView abc6() {
		return new ModelAndView("list","msg","post요청성공여긴어디나는누구6");
	}
	
	@PostMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg","post요청성공여긴어디나는누구7");
		return "list"; //모델 파라미터를 받고 리턴하면서 뷰 파일명만 적어주는 것 반환값은 스트링만 가져가는 것
	}
	
	@GetMapping("test8")
	@ResponseBody
	public String abc8(Model model) {
		String value="일반적인 데이터(String,MAP,JSON 등을 전달)";
		return value; //모델 파라미터를 받고 리턴하면서 뷰 파일명만 적어주는 것 반환값은 스트링만 가져가는 것
	}
	
	@GetMapping("test8_1")
	@ResponseBody
	public DataDto abc8_1() {
		DataDto dto=new DataDto();
		dto.setCode(5);
		dto.setName("신기하냐짜식아");
		return dto; //JSON 형태로 반환(jackson 라이브러리가 자동 지원)
	}
	
}










