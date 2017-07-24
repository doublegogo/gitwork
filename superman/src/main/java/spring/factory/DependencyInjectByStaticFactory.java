package spring.factory;

import spring.HelloApi;
import spring.HelloImpl3;

/** 静态工厂注入
 * Created by Administrator on 2017/7/25.
 */
public class DependencyInjectByStaticFactory {

    public static HelloApi newInstance(String message, int index) {
        return new HelloImpl3(message, index);
    }
}
