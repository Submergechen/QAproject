package com.qaproject.aspect;



import javafx.scene.media.VideoTrack;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
@Aspect
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    //第一个*是h返回值的意思  然后是类名 再后面的是方法名  ..是各种各样的参数
    @Before("execution(* com.qaproject.controller.*.*(..))")
    public void beforeMethod(){
        logger.info("before method");
    }

    @After("execution(* com.qaproject.controller.*.*(..))")
    public void afterMethod(){
        logger.info("after method");
    }
}
