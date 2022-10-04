package test.juc;


import java.util.concurrent.TimeUnit;

/**
 * @author: cg1
 * @date: 2021-08-10 14:32
 **/
public class InterruptedTest {
    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                //在抛出异常之间,是否中断->reset ->变为false
            } catch (InterruptedException e) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                System.out.println(interrupted);
                e.printStackTrace();
            }
        });
        boolean interrupted = thread.isInterrupted();
        System.out.println(interrupted);
        thread.start();
        thread.interrupt();


    }

}
