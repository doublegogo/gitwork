import org.junit.Assert;
import org.junit.Test;
import spring.HelloImpl2;
import spring.factory.DefaultBeanFactory;
import spring.scope.BeanDefinition;
import spring.scope.SingletonBeanRegister;
import spring.scope.SingletonClassLoader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/25.
 */
public class SingletonTest {

    @Test
    public void testSingleton() throws Exception {
        //第一个单例
        //1.创建一个ClassLoader
        ClassLoader classLoader = new SingletonClassLoader();
        //2.加载需要的类
        Class clazz = classLoader.loadClass("spring.scope.Singleton");
        //3.通过反射获取单例对象
        Method getInstance = clazz.getDeclaredMethod("getInstance");
        Object singletonObj = getInstance.invoke(clazz);
        //4.通过反射获取字段counter值
        Field counterField = clazz.getDeclaredField("counter");
        counterField.setAccessible(true);
        Integer counter = (Integer) counterField.get(singletonObj);
        //5.对字段counter自增1
        counterField.set(singletonObj, counter + 1);
        //6.验证counter=1
        Assert.assertEquals(1, counterField.get(singletonObj));
        System.out.println(counterField.get(singletonObj));

        //第二个单例
        //1.创建一个ClassLoader
        ClassLoader classLoader2 = new SingletonClassLoader();
        //2.加载需要的类
        Class clazz2 = classLoader2.loadClass("spring.scope.Singleton");
        //3.通过反射获取单例对象
        Method getInstance2 = clazz2.getDeclaredMethod("getInstance");
        Object singletonObj2 = getInstance2.invoke(clazz2);
        //4.通过反射获取字段counter值
        Field counterField2 = clazz2.getDeclaredField("counter");
        //5.对字段counter自增1
        counterField2.setAccessible(true);
        Integer counter2 = (Integer) counterField2.get(singletonObj2);
        counterField2.set(singletonObj2, counter2 + 1);
        //6.验证counter=1
        Assert.assertEquals(1, counterField2.get(singletonObj2));
        System.out.println(counterField2.get(singletonObj2));


        //以上就证明了每个ClassLoader一个单例

    }

    @Test
    public void testRegister() {
        SingletonBeanRegister register = new SingletonBeanRegister();
        register.registerSingleton("bean1", new HelloImpl2());
        HelloImpl2 bean1 = (HelloImpl2) register.getSingleton("bean1");
        bean1.sayHello();

        try {
            register.registerSingleton("bean1", new HelloImpl2());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testPrototype () throws Exception {
        //1.创建Bean工厂
        DefaultBeanFactory bf = new DefaultBeanFactory();
        //2.创建原型 Bean定义
        BeanDefinition bd = new BeanDefinition();
        bd.setId("bean");
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        bd.setClazz(HelloImpl2.class.getName());
        bf.registerBeanDefinition(bd);
        //对于原型Bean每次应该返回一个全新的Bean
        System.out.println(bf.getBean("bean") != bf.getBean("bean"));
    }
}
