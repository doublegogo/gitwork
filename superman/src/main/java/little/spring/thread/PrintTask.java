package little.spring.thread;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/19.
 */
@Component
public class PrintTask implements Runnable{
    String name;
    public void setName(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println(name + " is running.");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " is running again.");
    }
}
