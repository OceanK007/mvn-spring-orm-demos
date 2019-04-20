package com.ocean.mvn.spring.orm.demos.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component	// Use @Component else aspect won't work
public class LoggingMethodAspect 
{
	// Prerequisite: Logging.java annotation file is required
	// You have to explicitly define @LoggingMethod on methods 
	@Pointcut("@annotation(com.ocean.mvn.spring.orm.demos.aop.annotation.LoggingMethod)")
	public void anyMethodWithLoggingMethodAnnotation() {}
	
	// Prerequisite: Logging.java annotation file is required
	// You have to explicitly define @LoggingMethod on methods 
	@Pointcut("execution(@com.ocean.mvn.spring.orm.demos.aop.annotation.LoggingMethod * *(..))")
	public void anyMethodWithLoggingMethodAnnotation2() {}
	
	// Not any prerequisite required
	@Pointcut("execution(public * *(..)) && execution(@com.ocean.mvn.spring.orm.demos.aop.annotation.LoggingMethod * *(..))")
	public void anyPublicMethodAndWithLoggingMethodAnnotation() {}

	/**
	 1st * 	= any access modifier
	 2nd * 	= any class
	 3rd * 	= any method
	 .. 	= any number of parameter and type
	**/
	// Not any prerequisite required	
	@Pointcut("execution(* com.ocean.mvn.spring.orm.demos.api.endpoint.*.*(..)) || execution(* com.ocean.mvn.spring.orm.demos.service.impl.*.*(..)) || execution(* com.ocean.mvn.spring.orm.demos.data.repository.*.*(..))")
	public void onControllerServiceDaoPackage() {}
	
	// Not any prerequisite required	
	//@Pointcut("execution(* com.ocean.mvn.spring.orm.demos.api.endpoint.*.*(..)) || execution(* com.ocean.mvn.spring.orm.demos.api.mongodb.endpoint.*.*(..))")
	@Pointcut("execution(* com.ocean.mvn.spring.orm.demos.api.endpoint.*.*(..)) || execution(* com.ocean.mvn.spring.orm.demos.config.init.*.*(..))")
	public void onControllerPackage() {}
	
	@Around(value="onControllerPackage()")
	public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		System.out.println("========================================================================================================");
		System.out.println("======================================== START: Method Execution: "+proceedingJoinPoint.getSignature().toString());
		//System.out.println("Method Name: "+proceedingJoinPoint.getSignature().getName());
		//System.out.println("Method Name: "+proceedingJoinPoint.getSignature().toShortString());
		//System.out.println("Method Return Type & Signature: "+proceedingJoinPoint.getSignature().toString());
		//System.out.println("Method Args: "+Arrays.asList(proceedingJoinPoint.getArgs()));
		long startTime = System.currentTimeMillis();
		Object output = proceedingJoinPoint.proceed();
		System.out.println(String.format("=> Method execution time : %d milliseconds", System.currentTimeMillis() - startTime));
		System.out.println("======================================== END: Method Execution: "+proceedingJoinPoint.getSignature().toString());
		System.out.println("========================================================================================================");
		return output;
	}
}
