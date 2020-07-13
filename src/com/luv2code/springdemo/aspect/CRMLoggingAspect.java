/**
 * Developed by Artur Abratanski
 * based on course: https://www.udemy.com/course/spring-hibernate-tutorial/
 * ended with certificate: https://www.udemy.com/certificate/UC-93a7466f-d55f-4f75-a4f3-58f70e0bb6b1/
 */

/**
 * This is a AOP class for logging before and after certain executions.
 * It uses pointcuts for highest control.
 */

package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same for service and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @Before calling method: " + theMethod);
		
		// display the arguments to the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through and display args
		for (Object tempArg : args) {
			myLogger.info("==========>> argument: " + tempArg);
		}
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @AfterReturning from method: " + theMethod);		
		
		// display data returned
		myLogger.info("=========>> result: " + theResult);
	}

}
