package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class InsertController {
	
	@Autowired
	private BoardDao boardDao;
	
	//@GetMapping("insert")
	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String insert() {	
		return "insform";
	}
	
	//@PostMapping("insert")
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insertSubmit(BoardBean bean) {
		boolean b=boardDao.insertData(bean);
		
		
		if(b) {
			return "redirect:/list"; //추가 후 목록 보기
		}else{
			return "error";
		}
	}
}
