package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9")
public class TestController2 {
	
	//@RequestMapping(value="test9",method=RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET)
	public String def(Model model) {
		model.addAttribute("msg","써세스게뜨");
		return "list"; //이렇게 모두 요청하고 정리하는 것= 포워딩 방식
	}
	
	
	//@RequestMapping(value="test9",method=RequestMethod.POST)
	@RequestMapping(method=RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg","써세스포오스트");
		return "list"; //이렇게 모두 요청하고 정리하는 것= 포워딩 방식
	}
	
}
