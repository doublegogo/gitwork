package spring.scope;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/** 通过注册表方式
 * Created by Administrator on 2017/7/25.
 */
public class SingletonBeanRegister implements SingletonBeanRegistry {
    //单例Bean缓存池，此处不考虑并发
    private final Map<String, Object> BEANS = new HashMap<String, Object>();

    public boolean containsSingleton(String beanName) {
        return BEANS.containsKey(beanName);
    }

    public Object getSingleton(String beanName) {
        return BEANS.get(beanName);
    }

    @Override
    public int getSingletonCount() {
        return BEANS.size();
    }

    @Override
    public Object getSingletonMutex() {
        return null;
    }

    @Override
    public String[] getSingletonNames() {
        return BEANS.keySet().toArray(new String[0]);
    }

    @Override
    public void registerSingleton(String beanName, Object bean) {
        if (BEANS.containsKey(beanName)) {
            throw new RuntimeException("[" + beanName + "] 已存在");
        }
        BEANS.put(beanName, bean);
    }
}