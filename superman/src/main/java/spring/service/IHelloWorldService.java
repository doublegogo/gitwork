package spring.service;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface IHelloWorldService {

    public void sayHello();

    public void sayHllo();

    public void sayBefore(String param);

    public boolean sayAfterReturning();

    public void sayAfterThrowing();

    public boolean sayAfterFinally();

    public void sayAround(String param);

    public void sayAdvisorBefore(String param);





}
