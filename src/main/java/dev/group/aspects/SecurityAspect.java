package dev.group.aspects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import dev.group.beans.P2user;


@Aspect
@Component
public class SecurityAspect {
	
	//public static Gson gson= new Gson();

	@Around("secureMethod()")
	public Object authenticate(ProceedingJoinPoint pjp) throws Throwable{
		
		HttpServletRequest request = ((ServletRequestAttributes)
				RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpServletResponse response =((ServletRequestAttributes)
				RequestContextHolder.currentRequestAttributes()).getResponse();
		
		String roleOf = request.getHeader("authorizer");
		
		if("admin".toLowerCase().equals(roleOf)) {
			return pjp.proceed();
		}else {
			response.sendError(401);
			return false;
		}
	}
	
//	@Around("adminMethod()")
//	public Object LoginAuth(ProceedingJoinPoint pjp) throws Throwable{
//		
//		HttpServletRequest request = ((ServletRequestAttributes)
//				RequestContextHolder.currentRequestAttributes()).getRequest();
//		
//		HttpServletResponse response =((ServletRequestAttributes)
//				RequestContextHolder.currentRequestAttributes()).getResponse();
//		
//		P2user user = gson.fromJson(request.getReader(), P2user.class);
//		
//		if("admin".toLowerCase().equals(user.getRollof())) {
//			return pjp.proceed();
//		}else {
//			response.sendError(401);
//			return null;
//		}
//	}
	
	@Pointcut("@annotation(dev.group.aspects.Authorized)")
	public void secureMethod() {
		//nothing here
	}
	
//	@Pointcut("@annotation(dev.group.aspects.IsAdmin")
//	public void adminMethod() {
//		//nothing here
//	}
}
