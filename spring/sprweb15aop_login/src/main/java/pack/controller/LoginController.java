package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class LoginController {
	@Autowired
	private DataDao dao;

	@GetMapping("login")
	public String getLogin() {
		return "login";
	}

	@PostMapping("login")
	public String loginProcess(HttpSession session, 
			@RequestParam("no") String no, 
			@RequestParam("name") String name) {
		JikwonDto jikwonDto = dao.jikwonLogin(no);

		if (jikwonDto != null) {
			String returnName = jikwonDto.getJikwon_name();
			if(returnName.equals(name)) {
				session.setAttribute("name", returnName);
			}
		}
		return "redirect:/jikwonlist";
	}

	@GetMapping("logout")
	public String logoutProcess(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/";
	}
}
