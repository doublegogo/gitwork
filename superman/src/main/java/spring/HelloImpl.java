package spring;

/**
 * Created by Administrator on 2017/7/24.
 */
public class HelloImpl implements HelloApi{
    @Override
    public void sayHello() {
        System.out.println("Hello World!");

    }
}
