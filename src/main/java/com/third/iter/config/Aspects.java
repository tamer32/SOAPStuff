package com.third.iter.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects {
  @Pointcut("execution(* com.third.iter.web.UserController.createUser(..))")
  public void expInit() {
    System.out.println("This is the @Pointcut");
  }

  @Before("expInit()")
  public void beforeAnno() {
    System.out.println("@Before create user");
  }

  /* @Pointcut("execution(* com.CRUDAppTheSecound.Controller.UserController.*(..))")
  public void pointCutAll() {}

  @AfterReturning("pointCutAll()")
  public void afterReturningAll() {
    System.out.println("After returning all advice");
  }*/
}
