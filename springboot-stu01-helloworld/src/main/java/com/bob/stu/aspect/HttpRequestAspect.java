package com.bob.stu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * http请求日志切面
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/14
 */
@Aspect() //切面注解
@Component
public class HttpRequestAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestAspect.class);
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 定义切入点
     */
    @Pointcut("execution(public * com.bob.stu.controller.*.*(..)))")
    public void logging() {
    }

    /**
     * 在方法之前打印日志
     * 日志内容：1.访问的url；2.访问的method；3.访问者ip；4.请求参数
     */
    @Before("logging()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("----------loggingBefore----------------");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("url={}", request.getRequestURL());
        logger.info("http_method={}", request.getMethod());
        logger.info("visitor_ip={}", request.getRemoteAddr());
        logger.info("class_method={}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("method_args={}", joinPoint.getArgs());
        startTime.set(System.currentTimeMillis());//设置开始时间
    }

    /**
     * 在方法之后打印日志
     */
    @After("logging()")
    public void doAfter() {
        logger.info("----------loggingAfter----------------");
    }

    @AfterReturning(returning = "object", pointcut = "logging()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
        logger.info("spend time : {} ", System.currentTimeMillis() - startTime.get());//计算程序执行时间
    }
}
