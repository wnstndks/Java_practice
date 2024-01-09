package pack.aspect;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginClass {
	public boolean loginCheck(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session= request.getSession();
		
		if(session.getAttribute("name")==null) {
			response.sendRedirect("login");
			return true;
		}
		else {
			return false;
		}
	}
}
