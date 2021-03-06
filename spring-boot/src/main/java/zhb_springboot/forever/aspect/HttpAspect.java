package zhb_springboot.forever.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private Log log = LogFactory.getLog(HttpAspect.class);
	
	private Logger loger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * zhb_springboot.forever.controller.GirlController.*(..))")
	public void log(){
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		log.info("before------------");
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		loger.info("url={}",request.getRequestURI());
		loger.info("method={}",request.getMethod());
		loger.info("ip={}",request.getRemoteAddr());
		loger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
		loger.info("args={}",joinPoint.getArgs());
		
	}
	
	@After("log()")
	public void doAfter(){
		log.info("after------------");
	}
	
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object){
		loger.info("response={}",object.toString());
	}

}
