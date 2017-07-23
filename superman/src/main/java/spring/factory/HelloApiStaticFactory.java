package spring.factory;

import spring.HelloApi;
import spring.HelloImpl2;

/**
 * Created by Administrator on 2017/7/24.
 */
public class HelloApiStaticFactory {

    //工厂方法
    public static HelloApi newInstance(String message) {
        //返回需要的Bean实例
        return new HelloImpl2(message);
    }
}
