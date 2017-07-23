package spring.factory;

import spring.HelloApi;
import spring.HelloImpl2;

/**
 * Created by Administrator on 2017/7/24.
 */
public class HelloApiInstanceFactory {
    public HelloApi newInstance(String message) {
        return new HelloImpl2(message);
    }
}
