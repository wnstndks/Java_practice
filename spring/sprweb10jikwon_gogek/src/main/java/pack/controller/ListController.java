package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.GogekDto;
import pack.model.JikwonDto;
import pack.model.JikwonGogekDao;

@Controller
public class ListController { //컨트롤러는 클라이언트 요청을 받고 모델 영역의 클래스와 통신을 하고 그 결과를 뷰 파일을 통해서 출력하는 역할을 하는 것
	//핸들러 매핑과 뷰 리절버가 내부에서 활동중인것
	@Autowired
	private JikwonGogekDao jikwonGogekDao;
	
	@GetMapping("list")
	public String showList(Model model) {
		List<JikwonDto> jlist=jikwonGogekDao.selectAll();
		model.addAttribute("jikwons",jlist); 
		return "list"; //request.setAttribute로 이해를 알아야 함 jsp처럼
	}
	
	@GetMapping("showgogek")
	public String showGogek(@RequestParam("jikwon_no")String jikwon_no,
			@RequestParam("jikwon_name")String jikwon_name,
			Model model) {
		List<GogekDto> glist=jikwonGogekDao.selectGogek(jikwon_no);
		
		model.addAttribute("jikwon_name",jikwon_name);
		model.addAttribute("gogeks",glist);
		model.addAttribute("count",glist.size());
		return "gogeklist";
	}
}
