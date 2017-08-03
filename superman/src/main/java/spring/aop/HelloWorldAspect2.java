package spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2017/7/27.
 */
@Aspect
public class HelloWorldAspect2 {


    @Pointcut(value="execution(* spring.service..*.sayAdvisorBefore(..)) && args(param)", argNames = "param")
    public void beforePointcut(String param) {}

    @Before(value = "beforePointcut(param)", argNames = "param")
    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }

}
