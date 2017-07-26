package spring.service.impl;

import spring.service.IHelloWorldService;

/**
 * Created by Administrator on 2017/7/27.
 */
public class HelloWorldService implements IHelloWorldService{
    public void sayHello() {
        System.out.println("============Hello World!");
    }

    public void sayHllo() {
        System.out.println("============Hello !");
    }

    @Override
    public void sayBefore(String param) {
        System.out.println("============say " + param);
    }

    @Override
    public boolean sayAfterReturning() {
        System.out.println("============after returning");
        return false;
    }

    @Override
    public void sayAfterThrowing() {
        System.out.println("============before throwing");
        throw new RuntimeException();
    }

    @Override
    public boolean sayAfterFinally() {
        System.out.println("============before finally");
        return false;
    }

    @Override
    public void sayAround(String param) {
        System.out.println("============around param:" + param);
    }

    @Override
    public void sayAdvisorBefore(String param) {
        System.out.println("============say " + param);
    }

}
