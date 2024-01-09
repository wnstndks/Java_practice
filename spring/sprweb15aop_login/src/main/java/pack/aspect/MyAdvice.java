package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Aspect
public class MyAdvice {
	@Autowired
	private LoginClass loginClass;

	@Around("execution(* jikProcess*(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request=null;
		HttpServletResponse response=null;
		
		for(Object obj:joinPoint.getArgs()) {
			if(obj instanceof HttpServletRequest) {
				request=(HttpServletRequest)obj;
			}
			if(obj instanceof HttpServletResponse) {
				response =(HttpServletResponse)obj;
			}
			
		}
		if(loginClass.loginCheck(request,response)){
			return null;
		}
		
		Object object = joinPoint.proceed();
		return object;
	}
}
