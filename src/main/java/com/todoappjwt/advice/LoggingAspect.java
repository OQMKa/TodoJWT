package com.todoappjwt.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* com.todoappjwt.service.TodoService.aspect())") //pointcut expressions
    public void loggingAspect(){
            System.out.println("A modular claSs containing the cross cutting concern logic, annoted with @Aspect. ");
        // System.out.println("Logging Aspect is called. - 1 @After ");
    }
}
