package spring.factory;

import spring.HelloApi;
import spring.HelloImpl3;

/** 实例工厂类
 * Created by Administrator on 2017/7/25.
 */
public class DependencyInjectByInstanceFactory {

    public HelloApi newInstance(String message,int index){
        return new HelloImpl3(message,index);
    }

}
