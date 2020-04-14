package com.big407.energy.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面，对日志进行处理
 */
@Aspect
@Component
public class LogAspect {


    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    private class RequestLog{
        private String url;
        private String ip;
        private String  classMethod;
        private Object[] args;

    }

    //声明为一个切面
    @Pointcut("execution(* com.big407.*.*(..))")
    public void log(){


    }

    /**
     * 调用之前
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获取request

        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        //url
        String url=request.getRequestURL().toString();
        //id地址
        String ip=request.getRemoteAddr();
        //方法
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        //参数
        Object[]args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
       logger.info("Request:{}",requestLog);


    }

    /**
     * 调用之后
     * @param result
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
      logger.info("Result:{}",result);
    }


}
