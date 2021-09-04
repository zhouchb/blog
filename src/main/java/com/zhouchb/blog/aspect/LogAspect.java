package com.zhouchb.blog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/2 :19:19
 * @Description
 */
@Aspect
@Slf4j
@Component
public class LogAspect {
    /**
     * @Author zhouchb
     * @Param []
     * @return void
     * @Description:  切面
     * @Date 19:25 2021/9/2
     */
    @Pointcut("execution(* com.zhouchb.blog.Controller.*.*(..))") //切入点  实际被增强的方法
    public void log(){
    }
    @Before("log()")
    public void doBefor(JoinPoint joinPoint){
    log.info("我是前置通知");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String classMethod ="class:"+ signature.getDeclaringTypeName()+",method:"+signature.getName();//类名和方法名
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        log.info("切面AspectLog{}",requestLog);
    }

    @After("log()")
    public void doAfter(){
        //log.info("我是后置通知");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(Object result){
        log.info("result（返回）的值为{}",result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
