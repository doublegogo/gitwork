import little.spring.thread.AppConfig;
import little.spring.thread.PrintTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**\adad
 * Created by Administrator on 2017/7/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class App {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor)ctx.getBean("taskExecutor");

        PrintTask printTask1 = (PrintTask)ctx.getBean("printTask");
        printTask1.setName("Thread 1");
        taskExecutor.execute(printTask1);

        PrintTask printTask2 = (PrintTask)ctx.getBean("printTask");
        printTask2.setName("Thread 2");
        taskExecutor.execute(printTask2);

        PrintTask printTask3 = (PrintTask)ctx.getBean("printTask");
        printTask3.setName("Thread 3");
        taskExecutor.execute(printTask3);

        for(;;){
            int count = taskExecutor.getActiveCount();
            System.out.println("Active Threads : " + count);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(count==0){
                taskExecutor.shutdown();
                break;
            }
        }
    }
}


























