package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.BoardDaoImpl;

@Controller
public class DeleteController {
	@Autowired
	private BoardDaoImpl daoImpl;
	
	@GetMapping("delete")
	public String del(@RequestParam("num")String num,
			@RequestParam("page")String page) {
		// 사실 비번 삭제는 비밀번호 비교해야 함. 생략...
		if(daoImpl.delete(num))
			return "redirect:list?page=" + page;
		else
			return "redirect:error";
	}
}
