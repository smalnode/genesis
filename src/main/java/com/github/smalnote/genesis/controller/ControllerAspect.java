package com.github.smalnote.genesis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(ControllerAspect.class);
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void requestMapping() {}

	@Around("requestMapping()")
	public Object aroundRequestMapping(ProceedingJoinPoint joinPoint) throws Throwable {
		LOG.debug("---------- before requestMapping ---------------");
        Object retVal = joinPoint.proceed();
		LOG.debug("---------- after requestMapping ----------------");
        return retVal;
	}

}
