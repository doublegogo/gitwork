package spring;

/**
 * Created by Administrator on 2017/7/25.
 */
public class HelloImpl3 implements HelloApi {


    private String message;
    private int index;
    //@java.beans.ConstructorProperties({"message", "index"})
    public HelloImpl3(String message, int index) {
        this.message = message;
        this.index = index;
    }

    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }
}
