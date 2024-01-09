package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController3 {
	@RequestMapping("/java/korea")
	public String ghi(Model model) {
		model.addAttribute("msg", "java/korea 요청성공브로");
		return "list";
	}
	
	@GetMapping({"/java/good","hello","world"})
	public String ghi2(Model model) {
		model.addAttribute("msg", "여러 값의 url 요청성공브로");
		return "list";
	}
	
}
