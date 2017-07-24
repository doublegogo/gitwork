package spring.scope;

/** 普通单例
 * 通过在类上定义静态属性保持该实例
 * Created by Administrator on 2017/7/25.
 */
public class Singleton {

    //1.私有化构造器
    private Singleton() {}
    //2.单例缓存者，惰性初始化，第一次使用时初始化
    private static class InstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    //3.提供全局访问点
    public static Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
    //4.提供一个计数器来验证一个ClassLoader一个实例
    private int counter=0;
}
