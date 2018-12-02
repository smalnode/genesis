package com.github.smalnote.genesis.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.smalnote.genesis.controller.Greeting;

@RestController
public class GreetingController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ControllerAspect.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path="/greeting", method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
    	HttpServletRequest req = attrs.getRequest();
    	String user = (String) attrs.getAttribute("user", 0);
    	String operation = (String) attrs.getAttribute("operation", 0);
    	LOG.debug(req.getRequestURI() + "?" + req.getQueryString());
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, user + "/" + operation));
    }
}
